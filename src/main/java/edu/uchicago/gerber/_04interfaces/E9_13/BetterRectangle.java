package edu.uchicago.gerber._04interfaces.E9_13;
import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {

    public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y); // Call the setLocation method of the Rectangle class
        super.setSize(width, height); // Call the setSize method of the Rectangle class
    }

    public double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    public double getArea() {
        return getWidth() * getHeight();
    }
}

