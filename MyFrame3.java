package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

//Make sure to change class name to your own class name\
public class MyFrame3 extends JFrame implements ActionListener {
	
    private JTextField subtotalField;
    private JLabel hstLabel;
    private JLabel totalLabel;
    private JButton calcButton;

    private static final double HST_RATE = 0.13;

    MyFrame3() {
        // Frame setup
        this.setTitle("Taxes Calculator");
        this.setSize(350, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 2, 10, 10));
        this.getContentPane().setBackground(Color.YELLOW);

        // Number formatter for currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // Labels and text fields
        JLabel subtotalText = new JLabel("Subtotal:");
        subtotalField = new JTextField("0.00");

        JLabel hstText = new JLabel("HST (13%):");
        hstLabel = new JLabel(currency.format(0));

        JLabel totalText = new JLabel("Total:");
        totalLabel = new JLabel(currency.format(0));

        calcButton = new JButton("Calculate Total");
        calcButton.addActionListener(this);

        // Add components to frame
        this.add(new JLabel("Taxes Calculator", SwingConstants.CENTER));
        this.add(new JLabel("")); // filler

        this.add(subtotalText);
        this.add(subtotalField);

        this.add(hstText);
        this.add(hstLabel);

        this.add(totalText);
        this.add(totalLabel);

        this.add(new JLabel("")); // filler
        this.add(calcButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double subtotal = Double.parseDouble(subtotalField.getText());
            double hst = subtotal * HST_RATE;
            double total = subtotal + hst;

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            hstLabel.setText(currency.format(hst));
            totalLabel.setText(currency.format(total));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new MyFrame3();
    }
}