package edu.uchicago.gerber._02arrays;
import java.util.Scanner;

public class P5_24 {
//    a program that converts a Roman number such as MCMLXXVIII to its decimal number representation.
//    to run the code, enter the roman number as prompted
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the roman number: ");
        String inputString = scanner.nextLine();
        System.out.println(romanToDecimal(inputString));
        scanner.close();
    }

    public static int romanToDecimal(String romanNumber) {
        int total = 0;
        while (!romanNumber.isEmpty()) {
            if (romanNumber.length() == 1 || getValue(romanNumber.charAt(0)) >= getValue(romanNumber.charAt(1))) {
                total += getValue(romanNumber.charAt(0));
                romanNumber = romanNumber.substring(1);
            } else {
                int difference = getValue(romanNumber.charAt(1)) - getValue(romanNumber.charAt(0));
                total += difference;
                romanNumber = romanNumber.substring(2);
            }
        }
        return total;
    }

    public static int getValue(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException();
        }
    }
}

