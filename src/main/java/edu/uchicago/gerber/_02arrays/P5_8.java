package edu.uchicago.gerber._02arrays;
import java.util.Scanner;

public class P5_8 {
//    a method that tests whether a year is a leap year: that is, a year with 366 days.
//    to run the code, enter the year as prompt
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int input = scanner.nextInt();
        System.out.println(isLeapYear(input));
        scanner.close();
    }
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return true;
        }
    }

}
