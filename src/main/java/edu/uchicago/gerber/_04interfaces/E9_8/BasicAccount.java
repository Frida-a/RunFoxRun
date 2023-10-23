package edu.uchicago.gerber._04interfaces.E9_8;

public class BasicAccount extends BankAccount {

    public BasicAccount() {
        super(); // Calls the constructor of the BankAccount superclass
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient funds. Cannot withdraw more than the current balance.");
        }
    }

    // Implement other methods specific to BasicAccount, if needed

}
