package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.model.Registration;

import java.util.Optional;

public interface AccountService {

    void submit(Registration registration);

    boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException;

    Optional<EndUserAccount> findEUAByMobile(String mobileNo);

}