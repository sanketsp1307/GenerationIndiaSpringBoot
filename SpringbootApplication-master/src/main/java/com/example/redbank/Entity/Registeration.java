package com.example.redbank.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "registeration_table")
public class Registeration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;
    private String emailId;
    private String userName;
    private String password;

    @Transient
    private String cpassword; // Not persisted in the database

    // Default constructor
    public Registeration() {
    }

    // Parameterized constructor
    public Registeration(int userId, String name, String emailId, String userName, String password, String cpassword) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.cpassword = cpassword;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    @Override
    public String toString() {
        return "Registration [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", userName=" + userName + "]";
    }
}
