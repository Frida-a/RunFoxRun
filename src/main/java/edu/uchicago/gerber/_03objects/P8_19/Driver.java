package edu.uchicago.gerber._03objects.P8_19;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting angle in degrees: ");
        double angle = scanner.nextDouble();

        System.out.print("Enter the initial velocity: ");
        double initialVelocity = scanner.nextDouble();

        Cannonball cannonball = new Cannonball(0.0);
        cannonball.shoot(angle, initialVelocity);

        scanner.close();
    }
}
