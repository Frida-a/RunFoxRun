package edu.uchicago.gerber._03objects.P8_19;

import java.util.Scanner;

public class Cannonball {
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;

    public Cannonball(double xPosition) {
        this.xPosition = xPosition;
        this.yPosition = 0.0;
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
    }

    public void move(double sec) {
        double distance = xVelocity * sec;
        xPosition += distance;
        yPosition += yVelocity * sec;
        yVelocity -= 9.81 * sec;
    }

    public double getX() {
        return xPosition;
    }

    public double getY() {
        return yPosition;
    }

    public void shoot(double angle, double initialVelocity) {
        xVelocity = initialVelocity * Math.cos(Math.toRadians(angle));
        yVelocity = initialVelocity * Math.sin(Math.toRadians(angle));

        while (yPosition >= 0) {
            move(0.1);
            if (yPosition >= 0) {
                System.out.println("Position: (" + getX() + ", " + getY() + ")");
            }
        }
    }


}

