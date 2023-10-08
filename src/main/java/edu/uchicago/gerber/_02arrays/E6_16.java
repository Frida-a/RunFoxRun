package edu.uchicago.gerber._02arrays;

import java.util.Scanner;

public class E6_16 {
//    Write a program that reads a sequence of input values and displays a vertical bar chart of the values, using asterisks
//    The tallest bar is twenty asterisks high. Shorter bars should use proportionally fewer asterisks.
//    To run the code, put in the length of the array and the array items as prompted
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
        int numValues = input.nextInt();

        int[] values = new int[numValues];
        int maxValue = 0;

        // Read input values and find the maximum value
        for (int i = 0; i < numValues; i++) {
            System.out.print("Enter value #" + (i + 1) + ": ");
            values[i] = input.nextInt();
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        input.close();

        // Calculate the scaling factor for the asterisks
        double scalingFactor = 20.0 / maxValue;
        int[] scaledValues = new int[numValues];

        // Display the bar chart
        for (int i = 0; i < numValues; i++) {
            scaledValues[i] = (int) (values[i] * scalingFactor);
        }

        for (int row = 20; row >= 1; row--) {
            for (int col = 0; col < numValues; col++) {
                if (scaledValues[col] >= row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
