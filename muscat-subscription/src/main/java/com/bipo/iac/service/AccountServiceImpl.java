package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.repository.CustomerAccountRepository;
import com.bipo.iac.repository.EndUserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private EndUserAccountRepository endUserAccountRepository;

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException {
        CustomerAccount customerAccount = new CustomerAccount(companyInformation.getCompanyName(), companyInformation.getCompanyScale(), companyInformation.getCompanyAddress());
        customerAccountRepository.save(customerAccount);

        EndUserAccount euAccount = findEUAByMobile(contactInformation.getMobile());
        if (euAccount != null) {
            throw new MobileRegisteredException();
        }
        EndUserAccount user = new EndUserAccount(contactInformation.getUserName(), contactInformation.getMobile(), contactInformation.getPassword());
        endUserAccountRepository.save(user);

        return true;
    }

    @Override
    public EndUserAccount findEUAByMobile(String mobileNo) {
        return endUserAccountRepository.findByMobileNo(mobileNo);
    }
}
