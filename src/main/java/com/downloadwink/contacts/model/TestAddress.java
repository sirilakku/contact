package com.downloadwink.contacts.model;

import java.sql.SQLException;

public class TestAddress {
    public static void main(String[] args) throws SQLException {
        AddressHome addressHome = AddressHome.getInstance();
//        Address address = addressHome.addAddress("777", "1st street", "Florida", "ABCD", "dfg456");
//        System.out.println(address);

        Address findById = addressHome.findById(10);
        System.out.println(findById);

//        Address updateText = addressHome.findById(6);
//        updateText.setStreetNumber("777777");
//        Address address = AddressHome.getInstance().updateAddress(findById, "333", "City center", "Calgary", "Alberta", "hhghhgfghf");
//        System.out.println(address);

        boolean deleteAddress = addressHome.deleteAddress(findById);
        System.out.println("Delete was " + deleteAddress);






    }
}
