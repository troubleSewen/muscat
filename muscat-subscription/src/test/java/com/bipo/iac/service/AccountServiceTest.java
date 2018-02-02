package com.bipo.iac.service;

import com.bipo.iac.dto.RegistrationDTO;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.EndUserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void process() {
        String abc = "1";
        assertThat(abc.length() == 1, is(true));
    }

//    @Ignore
    @Test
    public void each_registration_should_produce_one_account() throws MobileRegisteredException {
        RegistrationDTO registrationDTO = new RegistrationDTO(
                "Company name",
                "10~20",
                "No. 89, Taixing Rd, Jingan, Shanghai",
                "Hilary Lu",
                "123456",
                "18000000000");

        CompanyInformation companyInfo = new CompanyInformation(registrationDTO);
        ContactInformation contactInfo = new ContactInformation(registrationDTO);

        accountService.process(companyInfo, contactInfo);

        EndUserAccount userAccount = accountService.findEUAByMobile(contactInfo.getMobile());
        assertThat(userAccount, notNullValue());
    }
}