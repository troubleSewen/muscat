package com.bipo.iac.repository;

import com.bipo.iac.model.EndUserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.annotation.Nullable;

@Repository
public interface EndUserAccountRepository extends CrudRepository<EndUserAccount, Long> {

    @Nullable
    EndUserAccount findByMobileNo(String mobileNo);

}