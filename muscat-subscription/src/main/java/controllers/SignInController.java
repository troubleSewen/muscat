package controllers;

import model.CustomerAccount;
import model.EndUserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import service.AccountService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {
    @Autowired
    private AccountService AccountService;

    @RequestMapping(value = "/subscription/registration", method = RequestMethod.POST)
    public String SignIn(@RequestParam(value = "companyName") String companyName,
                         @RequestParam(value = "companyScale") String companyScale,
                         @RequestParam(value = "companyAddress") String companyAddress,
                         @RequestParam(value = "userName") String userName,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "mobileNo") String mobileNo) {

        EndUserAccount userExists = AccountService.findUserByUserName(userName);
        EndUserAccount mobileNoExists = AccountService.findUserByMobileNo(mobileNo);
        if (mobileNoExists != null) {
            return "There is already a user registered with the mobileNo provided";
        }

        if (userExists != null) {
            return "There is already a user registered with the username provided";
        }

        CustomerAccount customer = new CustomerAccount(companyName, companyScale, companyAddress);
        EndUserAccount user = new EndUserAccount(userName, mobileNo, password);
        AccountService.saveUser(user);
        AccountService.saveCustomer(customer);

        return customer.getCompanyName() + " Registration submitted successfully on " + customer.getSubmitDate();
    }
}