package edu.uchicago.gerber._07streams;
import java.util.ArrayList;
import java.util.List;
public class E13_20 {
    public static void listPaymentOptions(int price, List<Integer> bills, List<Integer> current, List<List<Integer>> result, int index) {
        if (price == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < bills.size(); i++) {
            int bill = bills.get(i);
            if (price >= bill) {
                current.add(bill);
                listPaymentOptions(price - bill, bills, current, result, i);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void printPaymentOptions(List<List<Integer>> result) {
        for (List<Integer> option : result) {
            System.out.println(option);
        }
    }

    public static void main(String[] args) {
        int price1 = 10;
        List<Integer> bills = new ArrayList<>();
        bills.add(100);
        bills.add(20);
        bills.add(5);
        bills.add(1);
        List<List<Integer>> result1 = new ArrayList<>();
        listPaymentOptions(price1, bills, new ArrayList<>(), result1, 0);
        System.out.println("Payment options for " + price1 + ":");
        printPaymentOptions(result1);

        int price2 = 25;
        List<List<Integer>> result2 = new ArrayList<>();
        listPaymentOptions(price2, bills, new ArrayList<>(), result2, 0);
        System.out.println("Payment options for " + price2 + ":");
        printPaymentOptions(result2);
    }
}
