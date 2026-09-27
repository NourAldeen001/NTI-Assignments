public class BankAccount {
    String accountNumber;
    String holderName;
    double balance;

    public BankAccount(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    }

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void displayInfo() {
        System.out.println("Account Number: " + accountNumber +
                ", Holder Name: " + holderName + ", Balance: " + balance);
    }

    void deposit(double amount) {
        if(amount < 0) return;
        balance += amount;
    }

    void withdraw(double amount) {
        if(amount < 0) return;
        if(amount > balance) return;
        balance -= amount;
    }



}
