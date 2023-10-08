package edu.uchicago.gerber._02arrays;
import java.util.Scanner;

public class E6_9 {
//    Write a method that checks whether two arrays have the same elements in the same order.
//    to run the code, put in two arrays as prompted
    public static void main(String[] args) {
        int[] array1 = readArrayFromStdin();
        int[] array2 = readArrayFromStdin();
        System.out.print(equals(array1,array2));

    }
    public static int[] readArrayFromStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

}
