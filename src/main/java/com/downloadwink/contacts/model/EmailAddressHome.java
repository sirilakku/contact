package com.downloadwink.contacts.model;
import java.sql.*;

public class EmailAddressHome {
    private static EmailAddressHome instance = new EmailAddressHome();

    public static EmailAddressHome getInstance() {
        return EmailAddressHome.instance;
    }

    private Connection connect;

    private Connection getConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts", "root", "123");
        }
        return connect;
    }

    public EmailAddress addEmail(String email) throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        statement.execute("INSERT INTO emailaddresses (emailAddresses) VALUES ('" + email + "')");
        statement.close();

        ResultSet resultSet = connect.createStatement()
                .executeQuery("SELECT * FROM emailaddresses where emailAddresses = '" + email + "'");
        EmailAddress newEmail = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, newEmail);

        }
        return newEmail;
    }

    private static void extractEmailAddressFromResultSet(ResultSet resultSet, EmailAddress newEmail) throws SQLException {
        newEmail.setId(resultSet.getInt("emailId"));
        newEmail.setEmail(resultSet.getString("emailAddresses"));
    }

    public EmailAddress findById(int id) throws SQLException {

        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.emailaddresses where emailId = " + id);
        EmailAddress email = new EmailAddress();
        while (resultSet.next()) {
            extractEmailAddressFromResultSet(resultSet, email);

        }
        statement.close();
        return email;
    }

    public EmailAddress saveEmailAddress(EmailAddress emailAddress) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update mycontacts.emailaddresses set emailAddresses = ? where emailId = ?");
        preparedStatement.setString(1,emailAddress.getEmail());
        preparedStatement.setInt(2,emailAddress.getId());
        preparedStatement.executeUpdate();
        return  emailAddress;
    }

    public boolean deleteEmail(EmailAddress deleteEmail) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from mycontacts.emailaddresses where emailId = ?");
        preparedStatement.setInt(1,deleteEmail.getId());
        int result = preparedStatement.executeUpdate();
//        if(result == 0){
//            return false;
//        } else {
//            return true;
//        }
        return result == 0 ? false : true;
    }
}
