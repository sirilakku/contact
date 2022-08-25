package com.downloadwink.contacts.model;

import java.sql.SQLException;
import java.util.List;

public class TestPrintContact {

    public static void main(String[] args) throws SQLException {
        ContactHome contacts = ContactHome.getInstance();
        contacts.addContact("Ronald","Donald");
        List<Contact> contacts1 = contacts.allContacts();

        for(Contact contact : contacts1){
            System.out.println(contact);
        }


//        List<Contact> allContacts = contacts.allContacts();
//        System.out.println("All contacts: ");
//        if (allContacts.size() > 0) {
//            for (Contact e : allContacts) {
//                System.out.println(e);
//            }
//        } else {
//            System.out.println("No record found");
//        }

        //List<Contact> someContacts = contacts.findByFirstName("siri");
//        System.out.println("There are " + someContacts.size() + " contacts.");
//        if (someContacts.size() > 0) {
//            System.out.println("The first contact is "+ someContacts.get(0));
//            for (Contact contact : someContacts) {
//                System.out.println(contact);
//            }
////        }
//        for (Contact newContact : someContacts){
//            System.out.println(newContact);
//        }

//        System.out.println("-------");
//        List<Contact> contactByLastName = contacts.findByLastName("abc");
//        for(Contact contactlastname : contactByLastName ){
//            System.out.println(contactlastname );
//        }
//
//        System.out.println(contacts.findByPhoneNumber("3333"));
//        System.out.println("********");
//
//        for(Contact contactByEmail : contacts.findByEmail("siri@lakku.ca" )){
//            System.out.println(contactByEmail );
//        }
//
//        System.out.println(contacts.addNewContact("ABC","DEF","ABC@DEF","6666"));
//        System.out.println(contacts.deleteContact("ABC","DEF","ABC@DEF"));

//        for(Contact contact: contacts.findByBirthday("01/01/01")) {
//            System.out.println(contact);
//        }
    }
}
