package com.downloadwink.contacts;

import com.downloadwink.contacts.controller.MainController;
import com.downloadwink.contacts.controller.UpdateContactPanelController;
import com.downloadwink.contacts.model.Contact;
import com.downloadwink.contacts.model.ContactHome;
import com.downloadwink.contacts.view.UpdateContactPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Contact byId = ContactHome.getInstance().findById(4);
        UpdateContactPanel updateContactPanel = new UpdateContactPanel(byId);
        UpdateContactPanelController updateContactPanelController = new UpdateContactPanelController(updateContactPanel,byId);
        MainController mainController = new MainController(updateContactPanelController.getView(),byId);
        JFrame mainFrame = new JFrame();
        mainFrame.getContentPane().add(mainController.getView().$$$getRootComponent$$$());
        mainFrame.setSize(400,600);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
