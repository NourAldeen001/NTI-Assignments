package org.bank.models;

import org.bank.exceptions.InvalidAmountException;

public class SavingsAccount extends Account {

    private double interestRate = 2.5;

    public SavingsAccount(String accountNumber, double balance, Customer customer) throws InvalidAmountException {
        super(accountNumber, balance, customer);
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}
