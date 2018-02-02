package com.bipo.iac.model;

import javax.persistence.*;

@Entity
public class EndUserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String mobileNo;

    @Column
    private String password;

    public EndUserAccount() {
    }

    public EndUserAccount(String name, String mobileNo, String password) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }
}
