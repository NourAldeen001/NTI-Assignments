package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void withdraw(String accountId, double amount) {
        System.out.println("Withdrawing " + amount + "$ from " + accountId);
    }

    public void deposit(String accountId, double amount) {
        System.out.println("Depositing " + amount + "$ to " + accountId);
    }

    public double getBalance() {
        return 120000.50;
    }

    public void willThrowException() {
        throw new RuntimeException("I don't find you");
    }
}
