package edu.uchicago.gerber._04interfaces.P9_6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        // Create an array of Appointment objects
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Onetime("See the dentist", 2022, 9, 20));
        appointments.add(new Daily("Take medication", 2022, 9, 20));
        appointments.add(new Monthly("Pay bills", 2022, 9, 5));
        appointments.add(new Monthly("Attend book club", 2022, 9, 10));

        // Get input from the user for a date
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month: ");
        int month = scanner.nextInt();

        System.out.print("Enter the day: ");
        int day = scanner.nextInt();


        // Print out all appointments that occur on the input date
        for (Appointment appointment : appointments) {
            if (appointment.occursOn(year, month, day)) {
                System.out.println(appointment.getDescription());
            }
        }
        scanner.close();
    }
}
