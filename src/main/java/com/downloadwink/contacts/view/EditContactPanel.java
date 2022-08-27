package com.downloadwink.contacts.view;

import javax.swing.*;
import java.awt.*;


public class EditContactPanel extends JPanel {

    private final JButton saveButton;
    private final JTextField firstNameField;
    private final JTextField lastNameField;

    public EditContactPanel(){
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,2));
        this.add(jPanel,BorderLayout.NORTH);

        JLabel firstNameLabel = new JLabel();
        firstNameLabel.setText("First Name");
        jPanel.add(firstNameLabel);
        firstNameField = new JTextField();
        firstNameField.setColumns(15);
        jPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel();
        lastNameLabel.setText("Last Name");
        jPanel.add(lastNameLabel);
        lastNameField = new JTextField();
        lastNameField.setColumns(15);
        jPanel.add(lastNameField);



        saveButton = new JButton();
        saveButton.setText("Save");
        this.add(saveButton,BorderLayout.SOUTH);

    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }
}
