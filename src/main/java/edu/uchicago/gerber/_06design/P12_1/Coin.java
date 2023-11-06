package edu.uchicago.gerber._06design.P12_1;

public class Coin {
    private double value;
    private int quantity;

    public Coin(double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

}
