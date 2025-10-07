
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Make sure to change class name to your own class name\

public class MyFrame4 extends JFrame {

    private JTextField txtLength, txtWidth;
    private JComboBox<String> cmbUnit;
    private JLabel lblResult;

    public MyFrame4() {
        
        setTitle("Rectangle Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLayout(null);  
        getContentPane().setBackground(Color.GREEN);

       
        JLabel lblTitle = new JLabel("Area", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(100, 10, 150, 25);
        add(lblTitle);

        
        JLabel lblLength = new JLabel("Enter a number");
        lblLength.setBounds(20, 50, 120, 25);
        add(lblLength);

        txtLength = new JTextField();
        txtLength.setBounds(150, 50, 150, 25);
        add(txtLength);

        
        JLabel lblWidth = new JLabel("Enter another num...");
        lblWidth.setBounds(20, 90, 150, 25);
        add(lblWidth);

        txtWidth = new JTextField();
        txtWidth.setBounds(150, 90, 150, 25);
        add(txtWidth);

        
        JLabel lblUnit = new JLabel("Unit:");
        lblUnit.setBounds(20, 130, 50, 25);
        add(lblUnit);

        cmbUnit = new JComboBox<>(new String[]{"mm", "cm", "m"});
        cmbUnit.setSelectedItem("cm"); 
        cmbUnit.setBounds(150, 130, 100, 25);
        add(cmbUnit);

        JButton btnArea = new JButton("Area");
        btnArea.setBounds(50, 170, 100, 30);
        add(btnArea);

        JButton btnPerimeter = new JButton("Perimeter");
        btnPerimeter.setBounds(170, 170, 100, 30);
        add(btnPerimeter);

        
        lblResult = new JLabel("", SwingConstants.CENTER);
        lblResult.setBounds(20, 210, 300, 25);
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        lblResult.setForeground(Color.BLUE);
        add(lblResult);

        
        btnArea.addActionListener(e -> calculateArea());
        btnPerimeter.addActionListener(e -> calculatePerimeter());

        setVisible(true);
    }

    private void calculateArea() {
        try {
            int length = Integer.parseInt(txtLength.getText());
            int width = Integer.parseInt(txtWidth.getText());
            String unit = (String) cmbUnit.getSelectedItem();

            int area = length * width;
            lblResult.setText("The Area is " + area + " " + unit + "²");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers!");
        }
    }

    private void calculatePerimeter() {
        try {
            int length = Integer.parseInt(txtLength.getText());
            int width = Integer.parseInt(txtWidth.getText());
            String unit = (String) cmbUnit.getSelectedItem();

            int perimeter = 2 * (length + width);
            lblResult.setText("The Perimeter is " + perimeter + " " + unit);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers!");
        }
    }

    public static void main(String[] args) {
        new MyFrame4();
    }
}