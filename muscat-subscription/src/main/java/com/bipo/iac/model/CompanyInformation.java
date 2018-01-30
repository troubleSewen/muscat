package com.bipo.iac.model;

import com.bipo.iac.dto.RegistrationDTO;

public class CompanyInformation {
    private String companyName;
    private String companyScale;
    private String companyAddress;

    public CompanyInformation(RegistrationDTO registrationDTO) {
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
