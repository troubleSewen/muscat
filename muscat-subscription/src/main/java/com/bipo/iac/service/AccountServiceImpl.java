package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException {
        CustomerAccount customerAccount = new CustomerAccount(companyInformation.getCompanyName(), companyInformation.getCompanyScale(), companyInformation.getCompanyAddress());
        customerAccount.save(accountRepository);

        EndUserAccount mobileNoExists = findUserByMobileNo(contactInformation.getMobile());
        if (mobileNoExists != null) {
            throw new MobileRegisteredException();
        }
        EndUserAccount user = new EndUserAccount(contactInformation.getUserName(), contactInformation.getMobile(), contactInformation.getPassword());

        user.save(accountRepository);

        return true;
    }

    @Override
    public EndUserAccount findUserByMobileNo(String mobileNo) {
        if(accountRepository.hasUserWithMobile(mobileNo)){
            return accountRepository.getUserBy(mobileNo);
        }
        return null;
    }

    @Override
    public EndUserAccount findUserByUserName(String userName) {
        return null;
    }
}
