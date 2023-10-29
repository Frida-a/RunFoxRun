package edu.uchicago.gerber._05gui.P10_2;
import javax.swing.*;
import java.awt.*;

public class BullsEyeComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBullsEye(g);
    }

    private void drawBullsEye(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        int ringCount = Math.min(width, height) / 20; // Number of concentric rings
        Color[] colors = {Color.BLACK, Color.WHITE}; // Alternating colors

        int colorIndex = 0;
        for (int i = 0; i < ringCount; i++) {
            int ringWidth = (ringCount - i) * 20; // Width of each ring
            g.setColor(colors[colorIndex]);
            g.fillOval(centerX - ringWidth / 2, centerY - ringWidth / 2, ringWidth, ringWidth);
            colorIndex = (colorIndex + 1) % colors.length; // Switch color for the next ring
        }
    }
}
