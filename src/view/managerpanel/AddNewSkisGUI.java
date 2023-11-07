package view.managerpanel;

import javax.swing.*;
import java.awt.*;

public class AddNewSkisGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public AddNewSkisGUI() {
        setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Add new Skis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 330, 237);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBackground(new Color(255, 250, 205));
        textField.setBounds(60, 34, 200, 26);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel serialNumLabel = new JLabel("Serial Number");
        serialNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        serialNumLabel.setBounds(60, 20, 200, 16);
        contentPane.add(serialNumLabel);

        JLabel lengthLabel = new JLabel("Length");
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lengthLabel.setBounds(60, 72, 107, 16);
        contentPane.add(lengthLabel);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBackground(new Color(255, 250, 205));
        textField_1.setBounds(60, 91, 107, 26);
        contentPane.add(textField_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"allround", "allmountain", "lady", "race", "freeride", "freestyle"}));
        comboBox.setBounds(179, 92, 125, 27);
        contentPane.add(comboBox);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(113, 129, 117, 29);
        contentPane.add(saveButton);

        JLabel modelLabel = new JLabel("Model");
        modelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel.setBounds(179, 72, 125, 16);
        contentPane.add(modelLabel);
    }
}
