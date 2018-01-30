package com.bipo.iac.service;

import com.bipo.iac.model.CustomerAccount;
import com.bipo.iac.model.EndUserAccount;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
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
