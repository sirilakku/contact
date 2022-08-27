package com.downloadwink.contacts.controller;

import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.view.UpdateContactPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateContactPanelController {
    private UpdateContactPanel view;
    private Contact contact;

    public UpdateContactPanelController(UpdateContactPanel view, Contact contact){
        this.view = view;
        this.contact = contact;
        initialize();
    }

    private void initialize(){
        JButton deleteButton = view.getDeleteButton();
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pressed Delete ");
            }
        });


    }

    public UpdateContactPanel getView() {
        return view;
    }
}
