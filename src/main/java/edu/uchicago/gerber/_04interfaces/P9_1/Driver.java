package edu.uchicago.gerber._04interfaces.P9_1;

public class Driver {
    public static void main(String[] args) {
        Clock localClock = new Clock();
        System.out.println("Local Time: " + localClock.getTime());

        WorldClock worldClock = new WorldClock(3); // Timezone offset of 3 hours ahead
        System.out.println("World Time: " + worldClock.getTime());
    }
}
