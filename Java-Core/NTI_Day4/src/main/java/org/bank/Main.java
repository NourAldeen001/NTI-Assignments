package org.bank;

import org.bank.exceptions.AccountNotFoundException;
import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.InvalidAmountException;
import org.bank.exceptions.InvalidEmailException;
import org.bank.management.Bank;
import org.bank.models.Account;
import org.bank.models.CheckingAccount;
import org.bank.models.Customer;
import org.bank.models.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        try {
            // Bank
            Bank cib = new Bank();

            // Customers
//            Customer nr = new Customer(1, "VV", "nourgmail.com"); // bad
            Customer nour = new Customer(1, "Nour", "nour@gmail.com");
            Customer mohamed = new Customer(2, "Mohamed", "mo@gmail.com");

            // Accounts
//            Account account = new SavingsAccount("CC-666", -10, nour); // bad
            Account accountN = new SavingsAccount("CC-666", 1000, nour);
            Account accountM = new CheckingAccount("MM-888", 2000, mohamed);

            // Open Accounts
            cib.openAccount(accountN.getAccountNumber(), accountN);
            cib.openAccount(accountM.getAccountNumber(), accountM);

            // Look up
//            cib.getAccount("CC-99"); // bad
            cib.getAccount("CC-666");
            cib.getAccount("MM-888");

            // Transactions
//            cib.deposit("CC-666", -10); // bad
            cib.deposit("CC-666", 1000);
//            cib.withdraw("MM-888", 3000); // bad
            cib.withdraw("MM-888", 1000);

            // Get History
            int count = 1;
            System.out.println("---------------- Transactions History --------------");
            for(String s : cib.getTransactionHistory()) {
                System.out.println(count + ". " + s);
                count++;
            }

        }
        catch(InvalidEmailException ex) {
            System.out.println("Please, Enter Valid Email");
        }
        catch(IllegalArgumentException ex) {
            System.out.println("Please, Enter Your Name Correctly");
        }
        catch(InvalidAmountException e) {
            System.out.println("Please, Enter your balance with number greater than 0");
        }
        catch(InsufficientBalanceException e) {
            System.out.println("You haven't this money in your balance");
        }
        catch(AccountNotFoundException e) {
            System.out.println("This Account Not Found In System");
        }


    }
}