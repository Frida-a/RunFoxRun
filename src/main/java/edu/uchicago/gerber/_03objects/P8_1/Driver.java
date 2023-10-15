package edu.uchicago.gerber._03objects.P8_1;

public class Driver {
    public static void main(String[] args) {
        Microwave microwave = new Microwave();

        microwave.increaseTimeBy30Seconds();
        microwave.switchPowerLevel();
        microwave.start();

        microwave.reset();
        microwave.increaseTimeBy30Seconds();
        microwave.increaseTimeBy30Seconds();
        microwave.start();
    }
}
