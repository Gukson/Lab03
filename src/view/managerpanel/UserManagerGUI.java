package view.managerpanel;

import model.data.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class UserManagerGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(151, 89, 649, 333);
        contentPane.add(scrollPane);

        JLabel lblNewLabel_1 = new JLabel("User DB");
        lblNewLabel_1.setBounds(414, 61, 61, 16);
        contentPane.add(lblNewLabel_1);

        for(User u : users){
            scrollPane.add(new JLabel(u.getName()));
            System.out.println(u.getName());
//            revalidate();
        }

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }
}
