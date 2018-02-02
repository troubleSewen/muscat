package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.EndUserAccount;

public interface AccountService {

    boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException;

    EndUserAccount findEUAByMobile(String mobileNo);

}