package com.bipo.iac.service;

import com.bipo.iac.model.*;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.repository.CustomerAccountRepository;
import com.bipo.iac.repository.EndUserAccountRepository;
import com.bipo.iac.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private EndUserAccountRepository endUserAccountRepository;

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException {
        CustomerAccount customerAccount = new CustomerAccount(
                companyInformation.getCompanyName(),
                companyInformation.getCompanyScale(),
                companyInformation.getCompanyAddress());
        customerAccountRepository.save(customerAccount);

        Optional<EndUserAccount> endUserAccount = findEUAByMobile(contactInformation.getMobile());
        if(endUserAccount.isPresent()){
            throw new MobileRegisteredException();
        }

        endUserAccountRepository.save(new EndUserAccount(
                contactInformation.getUserName(),
                contactInformation.getMobile(),
                contactInformation.getPassword()));
        return true;
    }

    @Override
    public Optional<EndUserAccount> findEUAByMobile(String mobileNo) {
        return endUserAccountRepository.findByMobileNo(mobileNo);
    }

    @Override
    public void submit(Registration registration) {
        registrationRepository.save(registration);
    }
}
