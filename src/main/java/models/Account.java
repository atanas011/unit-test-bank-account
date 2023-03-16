package models;

import java.util.UUID;

public class Account {

    private final String name;
    private final String num;
    private double balance;

    public Account(String name, String num) {
        this.name = name;
        this.num = num;
        balance = 0d;
    }

    public Account(String name) { // constructor inside constructor
        this(name, UUID.randomUUID().toString());
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%.2f", num, name, balance);
    }
}