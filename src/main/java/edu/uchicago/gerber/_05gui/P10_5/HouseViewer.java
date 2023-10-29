package edu.uchicago.gerber._05gui.P10_5;

import javax.swing.*;

public class HouseViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("House Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        HouseDrawing houseDrawing = new HouseDrawing();
        frame.add(houseDrawing);

        frame.setVisible(true);
    }
}
