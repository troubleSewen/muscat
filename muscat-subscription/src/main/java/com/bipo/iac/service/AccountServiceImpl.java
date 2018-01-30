package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException {

        CustomerAccount customerAccount = new CustomerAccount(companyInformation.getCompanyName(), companyInformation.getCompanyScale(), companyInformation.getCompanyAddress());
        saveCustomer(customerAccount);

        EndUserAccount mobileNoExists = findUserByMobileNo(contactInformation.getMobile());
        if (mobileNoExists != null) {
            throw new MobileRegisteredException();
        }
        EndUserAccount user = new EndUserAccount(contactInformation.getUserName(), contactInformation.getMobile(), contactInformation.getPassword());

        saveUser(user);

        return true;
    }

    @Override
    public EndUserAccount findUserByMobileNo(String mobileNo) {
        return null;
    }

    @Override
    public EndUserAccount findUserByUserName(String userName) {
        return null;
    }

    @Override
    public void saveUser(EndUserAccount user) {

    }

    @Override
    public void saveCustomer(CustomerAccount customer) {

    }
}
