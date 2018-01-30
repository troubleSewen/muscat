package com.bipo.iac.repository;

import com.bipo.iac.model.EndUserAccount;
import org.springframework.stereotype.Component;

import java.util.Hashtable;

@Component
public class StubAccountRepositoryImpl implements AccountRepository {

    private static Hashtable<String, EndUserAccount> accounts = new Hashtable<>();

    @Override
    public boolean hasUserWithMobile(String mobileNo) {
        return accounts.containsKey(mobileNo);
    }

    @Override
    public EndUserAccount getUserBy(String mobileNo) {
        return accounts.get(mobileNo);
    }
}
