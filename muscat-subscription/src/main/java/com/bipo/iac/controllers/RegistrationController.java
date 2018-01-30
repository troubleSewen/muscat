package com.bipo.iac.controllers;

import com.bipo.iac.dto.RegistrationDTO;
import com.bipo.iac.exceptions.MobileRegisteredException;
import com.bipo.iac.model.CompanyInformation;
import com.bipo.iac.model.ContactInformation;
import com.bipo.iac.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/subscription/registration", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody RegistrationDTO registrationDTO) {
        try {
            CompanyInformation companyInformation = new CompanyInformation(registrationDTO);
            ContactInformation contactInformation = new ContactInformation(registrationDTO);

            if (accountService.process(companyInformation, contactInformation)) {
                return ResponseEntity.ok().build();
            }
        } catch (MobileRegisteredException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
