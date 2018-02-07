package com.bipo.iac.controllers;

import com.bipo.iac.dto.RegistrationDTO;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.Company;
import com.bipo.iac.model.Contact;
import com.bipo.iac.model.EndUserAccount;
import com.bipo.iac.model.Registration;
import com.bipo.iac.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/subscription")
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EndUserAccount> register(@RequestBody RegistrationDTO registrationDTO) {
        accountService.submit(new Registration(registrationDTO));

        try {
            Company companyInformation = new Company(registrationDTO);
            Contact contact = new Contact(registrationDTO);
            accountService.process(companyInformation, contact);

            EndUserAccount caa = new EndUserAccount();
            caa.setName(contact.getUserName());
            return new ResponseEntity<>(caa, HttpStatus.CREATED);

        } catch (MobileRegisteredException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("errors", e.getMessage());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}