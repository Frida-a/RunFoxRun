package edu.uchicago.gerber._06design.P12_1;

public class Driver {
    public static void main(String[] args) {
        // Create VendingMachine object
        VendingMachine vendingMachine = new VendingMachine();

        // Create and add products to the vending machine
        Product coke = new Product("Coke", 1.5, 10);
        Product chips = new Product("Chips", 1.0, 15);
        vendingMachine.addProduct(coke);
        vendingMachine.addProduct(chips);

        // Create and add coins to the vending machine
        Coin quarter = new Coin(0.25, 50);
        Coin dime = new Coin(0.1, 100);
        //vendingMachine.addCoin(quarter);
        //vendingMachine.addCoin(dime);

        // Create User object and interact with the vending machine
        User user = new User(vendingMachine);
        // User inserts coins
        user.insertCoin(quarter);
        user.insertCoin(dime);

        // User selects a product
        user.selectProduct(coke);
        }
    }
