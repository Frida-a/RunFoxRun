package edu.uchicago.gerber._07streams;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Stream;

public class E19_6 {
    public static void main(String[] args) {
        // Get the available currencies
        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();

        availableCurrencies.stream()
                .map(currency -> currency.getDisplayName(Locale.getDefault()))
                .sorted()
                .forEach(System.out::println);
    }
}

