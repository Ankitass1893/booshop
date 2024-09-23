package com.example.bookdemo.dao;


import org.springframework.data.annotation.Id;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
public class Customer {

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getFamilyMembers() {
        return familyMembers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ElementCollection
    private List<String> emails;  // Office, Personal emails

    @ElementCollection
    private List<String> familyMembers;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setFamilyMembers(List<String> familyMembers) {
        this.familyMembers = familyMembers;
    }
// Getters and setters
}

