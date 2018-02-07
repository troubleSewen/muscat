package com.bipo.iac.model;

import com.bipo.iac.dto.RegistrationDTO;
import javax.persistence.Embeddable;

@Embeddable
public class Company {
    private String companyName;
    private String companyScale;
    private String companyAddress;

    public Company() {
    }

    public Company(RegistrationDTO registrationDTO) {
        companyAddress = registrationDTO.getCompanyAddress();
        companyName = registrationDTO.getCompanyName();
        companyScale = registrationDTO.getCompanyScale();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }
}
