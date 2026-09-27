package org.bank.models;

import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.InvalidAmountException;

public abstract class Account {
    // Attributes
    private String accountNumber;
    private double balance;
    private Customer customer;

    // Constructors
    public Account(String accountNumber, double balance, Customer customer) throws InvalidAmountException {
        setBalance(balance);
        setAccountNumber(accountNumber);
        setCustomer(customer);
    }

    // Methods
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) throw new InvalidAmountException("Amount must greater than 0");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if(amount <= 0) throw new InvalidAmountException("Amount must greater than 0");
        if(amount > balance) throw new InsufficientBalanceException("Amount greater than your balance");
        balance -= amount;
    }

    public abstract String getAccountType();

    // Setters
    public void setAccountNumber(String accountNumber) {
        if(accountNumber.isBlank()) throw new IllegalArgumentException("Account Number must not be empty or blank");
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) throws InvalidAmountException {
        if(balance < 0) throw new InvalidAmountException("Balance must greater than 0");
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        if(customer == null) throw new NullPointerException();
        this.customer = customer;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}
