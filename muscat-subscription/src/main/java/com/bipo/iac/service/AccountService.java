package com.bipo.iac.service;

import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;

public interface AccountService {
    EndUserAccount findUserByMobileNo(String mobileNo);

    EndUserAccount findUserByUserName(String userName);

    void saveUser(EndUserAccount user);

    void saveCustomer(CustomerAccount customer);
}