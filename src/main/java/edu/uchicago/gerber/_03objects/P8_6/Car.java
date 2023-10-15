package edu.uchicago.gerber._03objects.P8_6;

public class Car {
    private double fuelEfficiency; // fuel efficiency in miles/gallon
    private double fuelLevel; // current fuel level in gallons

    public Car(double efficiency) {
        fuelEfficiency = efficiency;
        fuelLevel = 0;
    }

    public void drive(double distance) {
        double fuelUsed = distance / fuelEfficiency;
        fuelLevel -= fuelUsed;
    }

    public double getGasLevel() {
        return fuelLevel;
    }

    public void addGas(double gallons) {
        fuelLevel += gallons;
    }
}

