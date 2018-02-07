package com.bipo.iac.model;

import com.bipo.iac.dto.RegistrationDTO;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
    private String userName;
    private String mobile;
    private String password;

    public Contact() {
    }

    public Contact(RegistrationDTO registrationDTO) {
        this.userName = registrationDTO.getUserName();
        this.mobile = registrationDTO.getMobileNo();
        this.password = registrationDTO.getPassword();
    }

    public String getUserName() {
        return userName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }
}
