package edu.uchicago.gerber._06design.P12_1;

public class User {
    private VendingMachine vendingMachine;

    public User(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
    }

    public void selectProduct(Product product) {
        // Logic to select a product and initiate the transaction.
        double coinValue = vendingMachine.sumCoinValue();
        double price = product.getPrice();
        if (coinValue > price){
            vendingMachine.removeProduct(product);
            System.out.println("Product get!");
        }else{
            vendingMachine.removeCoin();
            System.out.println("Coins back!");
        }
    }

}
