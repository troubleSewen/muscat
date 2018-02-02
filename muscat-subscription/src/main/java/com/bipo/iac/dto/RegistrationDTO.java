package com.bipo.iac.dto;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {

    private String companyName;

    private String companyScale;

    private String companyAddress;

    private String userName;

    private String password;

    private String mobileNo;

    public RegistrationDTO() {

    }

    public RegistrationDTO(String companyName, String companyScale, String companyAddress, String userName, String password, String mobileNo) {
        this.companyName = companyName;
        this.companyScale = companyScale;
        this.companyAddress = companyAddress;
        this.userName = userName;
        this.password = password;
        this.mobileNo = mobileNo;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
