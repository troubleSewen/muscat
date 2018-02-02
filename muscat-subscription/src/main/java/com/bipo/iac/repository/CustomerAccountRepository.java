package com.bipo.iac.repository;

import com.bipo.iac.model.CustomerAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {

}
