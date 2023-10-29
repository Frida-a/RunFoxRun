package edu.uchicago.gerber._05gui.P11_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class CircleFrame extends JFrame {
    private Point center;
    private Point periphery;

    private CircleComponent circleComponent;

    public CircleFrame() {
        circleComponent = new CircleComponent();
        add(circleComponent);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (center == null) {
                    center = e.getPoint();
                } else if (periphery == null) {
                    periphery = e.getPoint();
                    circleComponent.repaint();
                }
            }
        });
    }

    private class CircleComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            if (center != null && periphery != null) {
                int radius = (int) center.distance(periphery);
                int diameter = radius * 2;
                int x = center.x - radius;
                int y = center.y - radius;
                Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

                g2.setColor(Color.BLACK);
                g2.draw(circle);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CircleFrame::new);
    }
}

