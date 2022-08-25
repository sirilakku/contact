package com.downloadwink.contacts.model;
import java.util.*;
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private EmailAddress personalEmail;
    private EmailAddress workEmail;
    private String birthdate;
    private int age;
    private String notes;
    private List<Contact> siblings;
    private Contact partner;
    private String phoneNumber;
    private Address primaryAddress;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmailAddress getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(EmailAddress personalEmail) {
        this.personalEmail = personalEmail;
    }

    public EmailAddress getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(EmailAddress workEmail) {
        this.workEmail = workEmail;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Contact> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Contact> siblings) {
        this.siblings = siblings;
    }

    public Contact getPartner() {
        return partner;
    }

    public void setPartner(Contact partner) {
        this.partner = partner;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalEmail=" + personalEmail +
                ", workEmail=" + workEmail +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", notes='" + notes + '\'' +
                ", siblings=" + siblings +
                ", partner=" + partner +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}
