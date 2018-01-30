package com.bipo.iac.dto;

public class RegistrationDTO {

    private final String companyName;

    private final String companyScale;

    private final String companyAddress;

    private final String userName;

    private final String password;

    private final String mobileNo;

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
