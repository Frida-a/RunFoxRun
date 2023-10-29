package edu.uchicago.gerber._05gui.P10_10;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class RingComponent extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the rings
        drawRing(g, Color.BLUE, 30, 30);
        drawRing(g, Color.BLACK, 100, 30);
        drawRing(g, Color.RED, 170, 30);
        drawRing(g, Color.YELLOW, 65, 60);
        drawRing(g, Color.GREEN, 135, 60);
    }

    private void drawRing(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.drawOval(x, y, 60, 60);
    }
}


