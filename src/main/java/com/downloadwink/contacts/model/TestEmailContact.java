package com.downloadwink.contacts.model;
import java.sql.SQLException;

public class TestEmailContact {
    public static void main(String[] args) throws Exception {
        EmailAddressHome emailAddresses = EmailAddressHome.getInstance();
        //EmailAddress emailAddress = emailAddresses.addEmail("sss@gmail.com");
        EmailAddress emailAddress = emailAddresses.findById(3);
        //EmailAddress newEmail = emailAddresses.addEmail("bbb@gmail.com");
        System.out.println(emailAddress);
        //System.out.println(newEmail);
        //emailAddress.setEmail("siri@gmail.com");
//        emailAddresses.saveEmailAddress(emailAddress);
//        EmailAddress byId = emailAddresses.findById(1);
//        System.out.println(byId);
        boolean email = emailAddresses.deleteEmail(emailAddress);
        System.out.println("Delete was " + email);


    }
}
