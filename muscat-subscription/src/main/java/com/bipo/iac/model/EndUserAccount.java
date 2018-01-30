package com.bipo.iac.model;

import com.bipo.iac.repository.AccountRepository;

public class EndUserAccount {
    private String name;
    private String mobileNo;
    private String password;

    public EndUserAccount(String name, String mobileNo, String password) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public void save(AccountRepository accountRepository) {

    }
}
