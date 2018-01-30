package com.bipo.iac.service;

import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;

public interface AccountService {

    boolean process(CompanyInformation companyInformation, ContactInformation contactInformation) throws MobileRegisteredException;

    EndUserAccount findUserByMobileNo(String mobileNo);

    EndUserAccount findUserByUserName(String userName);

    void saveUser(EndUserAccount user);

    void saveCustomer(CustomerAccount customer);
}