package com.bipo.iac.model;

import com.bipo.iac.dto.RegistrationDTO;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonSerialize(as = Contact.class)
    private Contact contact;

    @JsonSerialize(as = Company.class)
    private Company company;

    public Registration() {

    }

    public Registration(RegistrationDTO registrationDTO) {
        this.contact = new Contact(registrationDTO);
        this.company = new Company(registrationDTO);
    }

    public Long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
