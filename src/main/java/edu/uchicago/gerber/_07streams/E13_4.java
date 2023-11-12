package edu.uchicago.gerber._07streams;

public class E13_4 {
    public static String computeBinary(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            if (n % 2 == 0) {
                return computeBinary(n / 2) + "0";
            } else {
                return computeBinary(n / 2) + "1";
            }
        }
    }

    public static void main(String[] args) {
        int testNumber1 = 10;
        System.out.println("Binary representation of " + testNumber1 + ": " + computeBinary(testNumber1));

        int testNumber2 = 27;
        System.out.println("Binary representation of " + testNumber2 + ": " + computeBinary(testNumber2));
    }
}
