package edu.uchicago.gerber._03objects.P8_5;

public class Driver {
    public static void main(String[] args) {
        SodaCan sodaCan = new SodaCan(10.0, 5.0);

        double surfaceArea = sodaCan.getSurfaceArea();
        double volume = sodaCan.getVolume();

        System.out.printf("Surface Area: %.2f", surfaceArea);
        System.out.println();
        System.out.printf("Volume: %.2f" , volume);
    }
}
