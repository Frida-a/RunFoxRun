package edu.uchicago.gerber._05gui.P10_5;

import javax.swing.*;
import java.awt.*;

public class HouseDrawing extends JPanel {



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw multiple houses with different colors and positions
        drawHouse(g, 100, 400, 100, Color.RED);
        drawHouse(g, 300, 200, 150, Color.GREEN);
        drawHouse(g, 500, 300, 120, Color.BLUE);
    }

    private void drawHouse(Graphics g, int x, int y, int size, Color color) {
        // Set up the house dimensions based on the specified size
        int roofHeight = Math.round(size / 2);
        int houseHeight = Math.round(size / 2);
        int houseWidth = size;

        // Draw the house body
        g.setColor(color);
        g.fillRect(x, y + roofHeight, houseWidth, houseHeight);

        // Draw the roof
        int[] roofX = { x - roofHeight, x + houseWidth + roofHeight, x + (houseWidth / 2) };
        int[] roofY = { y + roofHeight, y + roofHeight, y };
        g.setColor(Color.GRAY);
        g.fillPolygon(roofX, roofY, 3);

        // Draw the door
        int doorWidth = Math.round(houseWidth / 4);
        int doorHeight = Math.round(houseHeight / 2);
        int doorX = x + (houseWidth / 4) - (doorWidth / 2);
        int doorY = y + roofHeight + houseHeight - doorHeight;
        g.setColor(Color.WHITE);
        g.fillRect(doorX, doorY, doorWidth, doorHeight);

        // Draw the windows
        int windowSize = Math.round(houseWidth / 4);
        int windowY = y + roofHeight + (houseHeight / 4);
        g.setColor(Color.WHITE);
        //g.fillRect(x + (houseWidth / 4), windowY, windowSize, windowSize);
        g.fillRect(x + (houseWidth / 2) + (houseWidth / 8), windowY, windowSize, windowSize);
    }
}
