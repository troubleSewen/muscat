package com.bipo.iac.controllers;

import com.bipo.iac.dto.RegistrationDTO;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.model.Registration;
import com.bipo.iac.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "/subscription")
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody RegistrationDTO registrationDTO) {
            // convert the registration dto to registration
        accountService.submit(new Registration());

        try {
            CompanyInformation companyInformation = new CompanyInformation(registrationDTO);
            ContactInformation contactInformation = new ContactInformation(registrationDTO);
            accountService.process(companyInformation, contactInformation);

        } catch (MobileRegisteredException e) {

            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}