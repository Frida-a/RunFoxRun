package edu.uchicago.gerber._02arrays;
import java.util.Arrays;
import java.util.Random;

public class E6_12 {
//    Write a program that generates a sequence of 20 random values between 0 and 99 in
//    an array, prints the sequence, sorts it, and prints the sorted sequence. Use the sort
//    method from the standard Java library.
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Original sequence:");
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("Sorted sequence:");
        System.out.println(Arrays.toString(array));
    }
}
