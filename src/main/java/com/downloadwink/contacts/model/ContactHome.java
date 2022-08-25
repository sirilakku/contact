package com.downloadwink.contacts.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactHome {

    private static ContactHome instance = new ContactHome();

    public static ContactHome getInstance() {
        return ContactHome.instance;
    }


    private List<Contact> contacts = new ArrayList<>();

    private ContactHome() {

    }


    public int addContact(String firstName, String lastName) throws SQLException {

        Connection connect = getConnection();
        PreparedStatement preparedS = connect.prepareStatement("Insert into mycontacts.contacts values (Default,?,?,?,?,?,?,?,?,?)");
        preparedS.setString(1,firstName);
        preparedS.setString(2, lastName);
        preparedS.setInt(3,0);
        preparedS.setString(4,null);
        preparedS.setInt(5,0);
        preparedS.setInt(6,0);
        preparedS.setString(7,null);
        preparedS.setInt(8,0);
        preparedS.setInt(9,0);
        int result = preparedS.executeUpdate();
        return result;
    }

    public List<Contact> allContacts() throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.contacts");
        List<Contact> allContacts = new ArrayList<>();
        while (resultSet.next()) {
            Contact contact = new Contact();
            extractContactFromResultSet(resultSet, contact);

            allContacts.add(contact);

        }
        statement.close();
        return allContacts;
    }

    private void extractContactFromResultSet(ResultSet resultSet, Contact contact) throws SQLException {
        contact.setId(resultSet.getInt("id"));
        contact.setFirstName(resultSet.getString("firstName"));
        contact.setLastName(resultSet.getString("lastName"));
        int personalEmailId = resultSet.getInt("personalEmailId");
        if (personalEmailId != 0) {
            contact.setPersonalEmail(EmailAddressHome.getInstance().findById(personalEmailId));
        }
    }
    public Contact findById(int id) throws SQLException {

        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from contacts where id= " +id);
        Contact contact = new Contact();
        while (resultSet.next()) {
            extractContactFromResultSet(resultSet, contact);
        }
        statement.close();
        return contact;
    }

    private  Connection getConnection() throws SQLException {
        Connection connect = DriverManager
                .getConnection("jdbc:mysql://localhost/mycontacts?"
                        + "user=root&password=123");
        return connect;
    }

    public List<Contact> findByFirstName(String nameFragment) {
        List<Contact> matchingContacts = new ArrayList<>();

        for (int i = 0;i < contacts.size(); i++ ) {
            Contact currentContact = contacts.get(i);
            if (currentContact.getFirstName().equalsIgnoreCase(nameFragment)) {
            matchingContacts.add(currentContact);
            }
        }
        return matchingContacts;
    }

    public List<Contact> findByLastName(String lastName ){
        List<Contact> matchingLastName = new ArrayList<>();

        for (int i =0; i< contacts.size();i++){
            Contact currentContact = contacts.get(i);
            if(currentContact.getLastName().equalsIgnoreCase(lastName)){
                matchingLastName.add(currentContact);
            }
        }

        if(matchingLastName.size()== 0){
            System.out.println("Contact name not found");
        }
        return matchingLastName;
    }

    public Contact findByPhoneNumber(String phoneNumber){
        Contact contactToFind = null;
        for (Contact contact: contacts) {
            if(contact.getPhoneNumber().equals(phoneNumber)){
                contactToFind = contact;
            }
        }
        return contactToFind;
    }

    public ArrayList<Contact> findByEmail(String email){
        ArrayList<Contact> emailToFind = new ArrayList<>();
        for (Contact contact: contacts){
            if(contact.getPersonalEmail().equals(email)){
                emailToFind.add(contact);
            }
        }
        return emailToFind;
    }

//    public ArrayList<Contact> findByBirthday(String birthday){
//        ArrayList<Contact> matchingContactsByBD = new ArrayList<>();
//        for (Contact contact: contacts){
//            if(contact.getBirthdate().equals(birthday)){
//                matchingContactsByBD.add(contact);
//            }
//
//        }
//        return matchingContactsByBD;
//    }

    public Contact addNewContact(String firstName, String lastName, String personalEmail, String phone ){
        Contact newContact = new Contact();
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        EmailAddress emailAddress = new EmailAddress();
        newContact.setPersonalEmail(emailAddress);
//        EmailAddress workEmailAddress = new EmailAddress(workEmail);
//        newContact.setWorkEmail(workEmailAddress);
        newContact.setPhoneNumber(phone);
        contacts.add(newContact);
        return newContact;
    }

    public Contact deleteContact(String firstName, String lastName, String personalEmail){
        Contact contactToDelete = new Contact();
        contactToDelete.getFirstName();
        contactToDelete.getLastName();
        contactToDelete.getPersonalEmail();
        contacts.remove(contactToDelete);
        return contactToDelete;

    }

}
