package com.bipo.iac.repository;

import com.bipo.iac.model.EndUserAccount;

public interface AccountRepository {

    boolean hasUserWithMobile(String mobileNo);

    EndUserAccount getUserBy(String mobileNo);
}