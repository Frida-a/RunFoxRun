package edu.uchicago.gerber._04interfaces.E9_13;

public class Driver {
    public static void main(String[] args) {
        BetterRectangle rect = new BetterRectangle(10, 20, 5, 8);
        double perimeter = rect.getPerimeter();
        double area = rect.getArea();

        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }
}
