package com.example.bankingapp;

public class ClientModel {
    private  int id;
    private String name;
    private String email;
    private String number;
    private String current_balance;
    private String account_number;

    //Constructors

    public ClientModel(String s, String toString)
    {

    }
    public ClientModel(int id, String name, String email, String number, String current_balance, String account_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.current_balance = current_balance;
        this.account_number = account_number;
    }

    //toString method is necessary to printing the content of the object
    @Override
    public String toString() {
        return "User=" +
                 + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", current_balance='" + current_balance + '\'' +
                ", account_number='" + account_number + '\'' +"";
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(String current_balance) {
        this.current_balance = current_balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
