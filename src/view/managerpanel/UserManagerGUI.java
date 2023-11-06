package view.managerpanel;

import model.data.User;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class UserManagerGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));

    public UserManagerGUI(List<User> users) {

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel navBar = new JPanel();
        navBar.setBorder(null);
        navBar.setBackground(Color.GRAY);
        navBar.setBounds(0, 0, 800, 45);
        contentPane.add(navBar);
        navBar.setLayout(null);

        JLabel NameSurname = new JLabel("Jakub Gurgul");
        NameSurname.setHorizontalAlignment(SwingConstants.RIGHT);
        NameSurname.setBounds(604, 6, 175, 16);
        navBar.add(NameSurname);

        JLabel role = new JLabel("Manager");
        role.setHorizontalAlignment(SwingConstants.CENTER);
        role.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
        role.setBounds(707, 23, 61, 16);
        navBar.add(role);

        JLabel lblNewLabel = new JLabel("SKI RENT");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        lblNewLabel.setBounds(204, 6, 408, 33);
        navBar.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 46, 150, 376);
        contentPane.add(panel);

        JButton userManager = new JButton("Storage");
        panel.add(userManager);

        JButton storageManager = new JButton("users DB");
        panel.add(storageManager);

        JLabel lblNewLabel_1 = new JLabel("User DB");
        lblNewLabel_1.setBounds(414, 61, 61, 16);
        contentPane.add(lblNewLabel_1);

        JPanel dataSection = new JPanel();
        dataSection.setBorder(null);
        dataSection.setBounds(151, 89, 649, 333);
        contentPane.add(dataSection);

        JPanel outerPanel = new JPanel(new BorderLayout());
        dataSection.add(outerPanel);
        outerPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(outerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        dataSection.setLayout(new BorderLayout());
        dataSection.add(scrollPane, BorderLayout.CENTER);


        for(User u : users){
            gereratePanels(u.getName(), u.getSurname());
        }

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    private void gereratePanels(String Name, String Surname){
        JPanel panel = new JPanel();
        panel.add(new JLabel(Name + " " + Surname));
        panel.add(Box.createHorizontalStrut(25));
        panel.add(new JButton("Bar"));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        rowHolderPanel.add(panel);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }

}


