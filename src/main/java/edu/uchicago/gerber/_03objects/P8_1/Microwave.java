package edu.uchicago.gerber._03objects.P8_1;

public class Microwave {
    private int time;
    private int powerLevel;

    public Microwave() {
        time = 0;
        powerLevel = 1;
    }

    public void increaseTimeBy30Seconds() {
        time += 30;
    }

    public void switchPowerLevel() {
        if (powerLevel == 1) {
            powerLevel = 2;
        } else {
            powerLevel = 1;
        }
    }

    public void reset() {
        time = 0;
        powerLevel = 1;
    }

    public void start() {
        System.out.println("Cooking for " + time + " seconds at level " + powerLevel + ".");
    }
}
