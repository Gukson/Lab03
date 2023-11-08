package view.managerpanel;

import exceptions.SaveNewSkiException;
import model.data.User;
import service.addnewski.AddNewSki;
import view.CoreUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewSkisGUI extends JFrame {

    private JPanel contentPane;
    private JTextField serialNumberField;
    private JTextField lengthField;

    public AddNewSkisGUI(AddNewSki addNewSki, CoreUI coreUI, User loggedUser) {
        //setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Add new Skis");
        setBounds(100, 100, 330, 237);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        serialNumberField = new JTextField();
        serialNumberField.setBackground(new Color(255, 250, 205));
        serialNumberField.setBounds(60, 34, 200, 26);
        contentPane.add(serialNumberField);
        serialNumberField.setColumns(10);

        JLabel serialNumLabel = new JLabel("Serial Number");
        serialNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        serialNumLabel.setBounds(60, 20, 200, 16);
        contentPane.add(serialNumLabel);

        JLabel lengthLabel = new JLabel("Length (cm)");
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lengthLabel.setBounds(60, 72, 107, 16);
        contentPane.add(lengthLabel);

        lengthField = new JTextField();
        lengthField.setColumns(10);
        lengthField.setBackground(new Color(255, 250, 205));
        lengthField.setBounds(60, 91, 107, 26);
        contentPane.add(lengthField);

        JComboBox modelBox = new JComboBox();
        modelBox.setModel(new DefaultComboBoxModel(new String[] {"allround", "allmountain", "lady", "race", "freeride", "freestyle"}));
        modelBox.setBounds(179, 92, 125, 27);
        contentPane.add(modelBox);

        JLabel modelLabel = new JLabel("Model");
        modelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel.setBounds(179, 72, 125, 16);
        contentPane.add(modelLabel);

        JLabel errorMessage = new JLabel("");
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setBounds(6, 170, 318, 16);
        errorMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setForeground(new Color(255, 30, 0));
        errorMessage.setBounds(480, 222, 240, 16);
        contentPane.add(errorMessage);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(113, 129, 117, 29);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //ustawić limity liter
                    addNewSki.AddNewSki(serialNumberField.getText(),Integer.parseInt(lengthField.getText()), String.valueOf(modelBox.getSelectedItem()));
                    coreUI.toggleStorageManager(loggedUser);
                    dispose();
                }catch (SaveNewSkiException e2){
                    errorMessage.setText("skis with this serial number already exist");
                }
            }
        });

        contentPane.add(saveButton);
    }
}
