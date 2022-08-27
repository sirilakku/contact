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
        int workEmailId = resultSet.getInt(("workEmailId"));
        if(workEmailId != 0 ){
            contact.setWorkEmail(EmailAddressHome.getInstance().findById(workEmailId));
        }
        contact.setPhoneNumber(resultSet.getString("phoneNumber"));
        contact.setAge(resultSet.getInt("age"));
        contact.setNotes(resultSet.getString("notes"));

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

    public Contact saveContact(Contact contact) throws SQLException {
        Connection connect = AddressHome.getInstance().getConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("Update mycontacts.contacts set firstName=?,lastName=?,phoneNumber=?,age=?,notes=? where id=?");
        preparedStatement.setString(1, contact.getFirstName());
        preparedStatement.setString(2, contact.getLastName());
        preparedStatement.setString(3,contact.getPhoneNumber());
        preparedStatement.setInt(4,contact.getAge());
        preparedStatement.setString(5, contact.getNotes());
        preparedStatement.setInt(6,contact.getId());
        preparedStatement.executeUpdate();
        return contact;
    }

    public Contact updateContact(Contact contact,String firstName, String lastName,String primaryEmail ,String phoneNumber, int age, String notes) throws SQLException {
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        EmailAddress email = new EmailAddress();
        email.setEmail(primaryEmail);
        contact.setPhoneNumber(phoneNumber);
        contact.setAge(age);
        contact.setNotes(notes);
        return saveContact(contact);
    }

    public void deleteContact(Contact contact) throws SQLException {
        Connection connect = ContactHome.getInstance().getConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("Delete from mycontacts.contacts where id=?");
        preparedStatement.setInt(1,contact.getId());
        preparedStatement.executeUpdate();
        System.out.println("Contact Deleted " + contact.getFirstName() + " " + contact.getLastName());

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

//    public Contact addNewContact(String firstName, String lastName, String personalEmail, String phone ){
//        Contact newContact = new Contact();
//        newContact.setFirstName(firstName);
//        newContact.setLastName(lastName);
//        EmailAddress emailAddress = new EmailAddress();
//        newContact.setPersonalEmail(emailAddress);
////        EmailAddress workEmailAddress = new EmailAddress(workEmail);
////        newContact.setWorkEmail(workEmailAddress);
//        newContact.setPhoneNumber(phone);
//        contacts.add(newContact);
//        return newContact;
//    }

//    public Contact deleteContact(String firstName, String lastName, String personalEmail){
//        Contact contactToDelete = new Contact();
//        contactToDelete.getFirstName();
//        contactToDelete.getLastName();
//        contactToDelete.getPersonalEmail();
//        contacts.remove(contactToDelete);
//        return contactToDelete;
//
//    }

}
