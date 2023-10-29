package edu.uchicago.gerber._05gui.P10_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RestaurantBillApp extends JFrame {
    private JTextArea billTextArea;
    private JTextField itemTextField;
    private JTextField priceTextField;
    private double totalBill;

    public RestaurantBillApp() {
        setTitle("Restaurant Bill App");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2));

        JButton pizzaButton = createItemButton("Pizza", 10.0);
        JButton burgerButton = createItemButton("Burger", 8.0);
        JButton tacosButton = createItemButton("Tacos", 4.0);
        JButton sushiButton = createItemButton("Sushi", 15.0);
        JButton chickenButton = createItemButton("Fried Chicken", 8.0);
        JButton pastaButton = createItemButton("Pasta", 12.0);
        JButton iceCreamButton = createItemButton("Ice Cream", 3.0);
        JButton coffeeButton = createItemButton("Coffee", 5.0);
        JButton beerButton = createItemButton("Beer", 8.0);
        JButton smoothiesButton = createItemButton("Smoothies", 8.0);

        buttonPanel.add(pizzaButton);
        buttonPanel.add(burgerButton);
        buttonPanel.add(tacosButton);
        buttonPanel.add(sushiButton);
        buttonPanel.add(chickenButton);
        buttonPanel.add(pastaButton);
        buttonPanel.add(iceCreamButton);
        buttonPanel.add(coffeeButton);
        buttonPanel.add(beerButton);
        buttonPanel.add(smoothiesButton);

        JPanel addItemPanel = new JPanel();
        addItemPanel.setLayout(new FlowLayout());
        //addItemPanel.setSize(200, 100);

        itemTextField = new JTextField(10);
        priceTextField = new JTextField(10);
        JButton addItemButton = new JButton("Add Custom Item");
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = itemTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                addItemToBill(item, price);
                billTextArea.append(item + " - $" + price + "\n");
                itemTextField.setText("");
                priceTextField.setText("");
            }
        });

        addItemPanel.add(new JLabel("Item:"));
        addItemPanel.add(itemTextField);
        addItemPanel.add(new JLabel("Price:"));
        addItemPanel.add(priceTextField);
        addItemPanel.add(addItemButton);

        JPanel billPanel = new JPanel();
        billPanel.setLayout(new BorderLayout());
        //billPanel.setSize(400, 300);

        JButton calculateBillButton = new JButton("Calculate Bill");
        calculateBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double tax = totalBill * 0.07; // Assuming 7% tax rate
                double tip = totalBill * 0.15; // Assuming 15% tip rate
                double totalAmount = totalBill + tax + tip;

                DecimalFormat df = new DecimalFormat("#.##");
                String billSummary = "Total: $" + df.format(totalBill) + "\n"
                        + "Tax: $" + df.format(tax) + "\n"
                        + "Tip: $" + df.format(tip) + "\n"
                        + "Total Amount: $" + df.format(totalAmount) + "\n";

                billTextArea.append("\n--- Bill Summary ---\n");
                billTextArea.append(billSummary);
            }
        });

        billTextArea = new JTextArea();
        billTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(billTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        billPanel.add(scrollPane, BorderLayout.CENTER);
        //billPanel.add(new JScrollPane(billTextArea), BorderLayout.CENTER);
        billPanel.add(calculateBillButton, BorderLayout.SOUTH);

        add(buttonPanel, BorderLayout.NORTH);
        add(addItemPanel, BorderLayout.CENTER);
        add(billPanel, BorderLayout.SOUTH);
    }

    private JButton createItemButton(String itemName, double itemPrice) {
        JButton button = new JButton(itemName + " - $" + itemPrice);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToBill(itemName, itemPrice);
                billTextArea.append(itemName + " - $" + itemPrice + "\n");
            }
        });
        return button;
    }

    private void addItemToBill(String itemName, double itemPrice) {
        totalBill += itemPrice;
    }


}
