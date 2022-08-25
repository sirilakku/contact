package com.downloadwink.contacts.model;

public class EmailAddress {
    private String email;
    private int id;

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public void validate() {
        int locationOfAt = email.indexOf('@');
        if (locationOfAt == -1) {
            throw new RuntimeException("Invalid email address");
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof String && email.equals(obj);
    }
}
