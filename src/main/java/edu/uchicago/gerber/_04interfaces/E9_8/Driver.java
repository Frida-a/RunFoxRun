package edu.uchicago.gerber._04interfaces.E9_8;

public class Driver {
    public static void main(String[] args) {
        BasicAccount account = new BasicAccount();
        account.deposit(1000); // Deposit 1000 to the account
        System.out.println("Current balance: " + account.getBalance());

        account.withdraw(500); // Withdraw 500 from the account
        System.out.println("Current balance: " + account.getBalance());

        account.withdraw(1500); // Try to withdraw 1500, which is more than the current balance
        System.out.println("Current balance: " + account.getBalance());
    }
}
