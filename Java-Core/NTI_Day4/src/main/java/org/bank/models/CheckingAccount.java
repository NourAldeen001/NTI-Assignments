package org.bank.models;

import org.bank.exceptions.InvalidAmountException;

public class CheckingAccount extends Account {

    private double overdraftAllowance = 100;

    public CheckingAccount(String accountNumber, double balance, Customer customer) throws InvalidAmountException {
        super(accountNumber, balance, customer);
    }


    public double getOverdraftAllowance() {
        return overdraftAllowance;
    }

    @Override
    public String getAccountType() {
        return "Checking Account";
    }
}
