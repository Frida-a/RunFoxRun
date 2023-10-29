package edu.uchicago.gerber._05gui.P10_10;

import javax.swing.*;
import java.awt.*;

public class RingViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setTitle("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        RingComponent component = new RingComponent();
        frame.add(component);

        frame.setVisible(true);
    }
}