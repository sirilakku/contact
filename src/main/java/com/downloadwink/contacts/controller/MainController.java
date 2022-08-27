package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.view.UpdateContactPanel;

import javax.swing.*;
import java.sql.SQLException;

public class MainController {
    private UpdateContactPanel view;
    private Contact contact;

   public MainController(UpdateContactPanel view,Contact contact){
        this.view = view;
        this.contact=contact;
    }

    public static void initializeMain() throws SQLException {
//        JFrame mainFrame = new JFrame();
//        Contact byId = ContactHome.getInstance().findById(4);
//        UpdateContactPanel updateContactPanel = new UpdateContactPanel(byId);
//
//        mainFrame.getContentPane().add(updateContactPanel.$$$getRootComponent$$$());
//        mainFrame.setSize(400,600);
//        mainFrame.setVisible(true);
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public UpdateContactPanel getView() {
        return view;
    }

    public void setView(UpdateContactPanel view) {
        this.view = view;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
