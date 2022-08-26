package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.view.EditContactPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditContactController {
    private final EditContactPanel view;
    private final ActionListener saveListener;

    private  Contact contact;
    public EditContactController(EditContactPanel view, Contact contact){
        this.view = view;
        this.contact=contact;
        view.getFirstNameField().setText(contact.getFirstName());
        view.getLastNameField().setText(contact.getLastName());
        saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    contact.setFirstName(view.getFirstNameField().getText());
                    contact.setLastName(view.getLastNameField().getText());
                    ContactHome.getInstance().saveContact(contact);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        view.getSaveButton().addActionListener(saveListener);

    }

    public void unhook() {
        System.out.println("Unhooking editor for " + contact.getFirstName());
        view.getSaveButton().removeActionListener(saveListener);
    }
}
