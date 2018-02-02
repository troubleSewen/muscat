package com.bipo.iac.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class CustomerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String rid;

    @Column
    private String companyName;

    @Column
    private String companyScale;

    @Column
    private String companyAddress;

    @Column
    private Date submitDate;

    public CustomerAccount(String companyName, String companyScale,
                           String companyAddress) {
        this.companyName = companyName;
        this.companyScale = companyScale;
        this.companyAddress = companyAddress;
        this.submitDate = Calendar.getInstance().getTime();
        this.rid = String.format(this.companyName, 4) + getSubmitDate();
    }

    public String getSubmitDate() {
        SimpleDateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatFull.format(submitDate);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
