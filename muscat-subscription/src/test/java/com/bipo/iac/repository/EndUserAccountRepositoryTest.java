package com.bipo.iac.repository;

import com.bipo.iac.model.EndUserAccount;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class EndUserAccountRepositoryTest {

    @Autowired
    private EndUserAccountRepository endUserAccountRepository;

    @Test
    public void verify_persistence_of_euar() {
        EndUserAccount endUserAccountToSave = new EndUserAccount();

        endUserAccountRepository.save(endUserAccountToSave);

        EndUserAccount userAccountFound = endUserAccountRepository.findOne(endUserAccountToSave.getId());
        assertThat(userAccountFound, notNullValue());
    }
}