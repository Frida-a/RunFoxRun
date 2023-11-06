package edu.uchicago.gerber._06design.P12_1;

import java.util.ArrayList;

public class VendingMachine {
    private ArrayList<Product> inventory;
    private ArrayList<Coin> coins;

    public VendingMachine() {
        inventory = new ArrayList<>();
        coins = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    public void restockProduct(Product product, int quantity) {
        product.restock(quantity);
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void removeCoin() {
        coins.clear();

    }

    public double sumCoinValue() {
        double value = 0;
        for (Coin c : coins){
            value += c.getValue()*c.getQuantity();
        }
        return value;
    }

}
