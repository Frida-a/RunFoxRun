package edu.uchicago.gerber._05gui.P10_19;

import javax.swing.*;

public class RestaurantBillViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RestaurantBillApp app = new RestaurantBillApp();
                app.setVisible(true);
            }
        });
    }
}
