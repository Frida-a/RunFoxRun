package edu.uchicago.gerber._05gui.P10_2;
import javax.swing.*;

public class BullsEyeViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bull's Eye");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(160, 160);
        frame.setLocationRelativeTo(null);

        BullsEyeComponent bullsEyeComponent = new BullsEyeComponent();
        frame.add(bullsEyeComponent);

        frame.setVisible(true);
    }
}
