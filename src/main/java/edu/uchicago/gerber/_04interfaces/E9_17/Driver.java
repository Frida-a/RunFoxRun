package edu.uchicago.gerber._04interfaces.E9_17;

public class Driver {
    public static void main(String[] args) {
        SodaCan sub = new SodaCan(1,1);

        Rectangle cerealBox = new Rectangle(5, 10);

        Measurable e = null;
        //a
        e = sub;
        //b
        //sub = e;
        //c
        sub = (SodaCan) e;
        //d
        //sub = (SodaCan) cerealBox;
        //e
        //e = cerealBox;
        //f
        e = (Measurable) cerealBox;
        //g
        //e = (Rectangle) cerealBox;
        //h
        //e = (Rectangle) null;
        // Create an array of SodaCans
        SodaCan[] sodaCans = new SodaCan[3];
        sodaCans[0] = new SodaCan(10, 5);
        sodaCans[1] = new SodaCan(8, 3);
        sodaCans[2] = new SodaCan(12, 4);

        // Calculate the average surface area
        double sum = 0;
        for (SodaCan sodaCan : sodaCans) {
            sum += sodaCan.getMeasure(); // Calls getSurfaceArea()
        }
        double averageSurfaceArea = sum / sodaCans.length;

        System.out.println("Average Surface Area: " + averageSurfaceArea);
    }
}
