package com.bipo.iac.service;

import com.bipo.iac.PayloadHelper;
import com.bipo.iac.dto.RegistrationDTO;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.Company;
import com.bipo.iac.model.Contact;
import com.bipo.iac.model.EndUserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void each_registration_should_produce_one_account() throws MobileRegisteredException {
        RegistrationDTO registrationDTO = PayloadHelper.fakeRegistrationDTO();

        Company companyInfo = new Company(registrationDTO);
        Contact contactInfo = new Contact(registrationDTO);

        accountService.process(companyInfo, contactInfo);

        Optional<EndUserAccount> endUserAccount = accountService.findEUAByMobile(contactInfo.getMobile());
        assertTrue(endUserAccount.isPresent());
    }
}