package edu.uchicago.gerber._05gui.P10_9;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class FlagComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Fill the background with white color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the German flag
        drawFlag(g, Color.BLACK, Color.RED, Color.YELLOW, 0, 0, getWidth(), getHeight() / 3);

        // Draw the Hungarian flag
        drawFlag(g, Color.RED, Color.WHITE, Color.GREEN, 0, getHeight() * 2 / 3, getWidth(), getHeight() / 3);
    }

    private void drawFlag(Graphics g, Color color1, Color color2, Color color3, int x, int y, int width, int height) {
        // Draw three horizontal colored stripes
        g.setColor(color1);
        g.fillRect(x, y, width, height / 3);
        g.setColor(color2);
        g.fillRect(x, y + height / 3, width, height / 3);
        g.setColor(color3);
        g.fillRect(x, y + height * 2 / 3, width, height / 3);
    }
}


