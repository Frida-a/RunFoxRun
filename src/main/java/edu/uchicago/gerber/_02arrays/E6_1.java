package edu.uchicago.gerber._02arrays;
import java.util.Random;
public class E6_1 {
//    Write a program that initializes an array with ten random integers and then prints four lines of output, containing
//      • Every element at an even index.
//      • Every even element.
//      • All elements in reverse order.
//      • Only the first and last element.
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        // Initialize the array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        // Print every element at an even index
        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i]+ "\t");
        }
        System.out.println();

        // Print every even element
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i]+ "\t");
            }
        }
        System.out.println();

        // Print all elements in reverse order
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]+ "\t");
        }
        System.out.println();

        // Print only the first and last element
        System.out.print(array[0]+ "\t");
        System.out.print(array[array.length - 1]);
        System.out.println();
    }
}
