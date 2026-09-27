package org.bank.management;

import org.bank.exceptions.AccountNotFoundException;
import org.bank.exceptions.DuplicateAccountException;
import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.InvalidAmountException;
import org.bank.models.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bank {
    // Attributes
    private Map<String, Account> accounts = new HashMap<>();
    private List<String> transactionHistory = new LinkedList<>();
    private final static Logger log = LoggerFactory.getLogger(Bank.class);


    // Methods
    public Account getAccount(String accountNumber) {
        log.info("Looking up account {}", accountNumber);
        Account account = null;
        if(!accountNumber.isBlank()) {
           account = accounts.get(accountNumber);
        }
        if(account == null) {
            log.warn("Lookup Failed: account {} not found", accountNumber);
            throw new AccountNotFoundException("Account Not Found");
        }
        log.info("Account {} Found", accountNumber);
        return account;
    }

    public void openAccount(String accountNumber, Account account) {
        log.info("Opening Account: {}", accountNumber);
        if(!accountNumber.isBlank()) {
            if (!accounts.containsKey(accountNumber)) {
                accounts.put(accountNumber, account);
                log.info("Account {} opened successfully", accountNumber);
            }
            else {
                log.warn("Account {} opened failed", accountNumber);
                throw new DuplicateAccountException("Account is already exists");
            }
        }
    }

    public void deposit(String accountNumber, double amount) throws InvalidAmountException {
        log.info("Attempt Deposit {} To Account: {}", amount, accountNumber);
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        transactionHistory.add("Deposited $" + amount + " into account " + accountNumber);
        log.info("Account {} deposit {} successfully. New balance: ${}", accountNumber, amount, account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) throws InsufficientBalanceException, InvalidAmountException {
        log.info("Attempt Withdraw {} From Account: {}", amount, accountNumber);
        Account account = getAccount(accountNumber);
        account.withdraw(amount);
        transactionHistory.add("Withdraw $" + amount + " from account " + accountNumber);
        log.info("Account {} withdraw {} successfully. New balance: ${}", accountNumber, amount, account.getBalance());
    }

    public List<String> getTransactionHistory() {
        log.info("Getting Transactions History");
        return transactionHistory;
    }
}
