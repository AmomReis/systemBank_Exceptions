package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
    private final int number;
    private final String holder;
    private Double balance;
    private final Double withdrawLimit;

    public Account(int number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > withdrawLimit) {
            throw new DomainExceptions("The amount exceeds withdraw limit");
        }
        if (amount > balance) {
            throw new DomainExceptions("Not enough balance");
        }
        System.out.println("New balance: " + balance);
    }
}
