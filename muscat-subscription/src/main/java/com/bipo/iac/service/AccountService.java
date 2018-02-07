package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.Company;
import com.bipo.iac.model.Contact;
import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.model.Registration;

import java.util.Optional;

public interface AccountService {

    void submit(Registration registration);

    boolean process(Company companyInformation, Contact contact) throws MobileRegisteredException;

    Optional<EndUserAccount> findEUAByMobile(String mobileNo);

}