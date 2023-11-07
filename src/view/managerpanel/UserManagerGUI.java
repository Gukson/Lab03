package view.managerpanel;

import model.data.User;
import view.CoreUI;
import view.RegistrationGUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserManagerGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, navBar, navigation, dataSection, outerPanel;
    private JScrollPane scrollPane;
    private JLabel NameSurname, role, logo, pageTitle;
    private JButton storage, usersDb, logOutButton;
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));

    public UserManagerGUI(List<User> users, User user) {

        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.LIGHT_GRAY);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.navBar = new JPanel();
        this.navBar.setBorder(null);
        this.navBar.setBackground(Color.GRAY);
        this.navBar.setBounds(0, 0, 800, 45);
        contentPane.add(this.navBar);
        this.navBar.setLayout(null);

        this.NameSurname = new JLabel(user.getName() + " " + user.getSurname());
        this.NameSurname.setHorizontalAlignment(SwingConstants.RIGHT);
        this.NameSurname.setBounds(604, 6, 175, 16);
        navBar.add(this.NameSurname);

        this.role = new JLabel(user.getRole());
        this.role.setHorizontalAlignment(SwingConstants.CENTER);
        this.role.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
        this.role.setBounds(707, 23, 61, 16);
        navBar.add(this.role);

        this.logo = new JLabel("SKI RENT");
        this.logo.setHorizontalAlignment(SwingConstants.CENTER);
        this.logo.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        this.logo.setBounds(204, 6, 408, 33);
        navBar.add(this.logo);

        this.navigation = new JPanel();
        this.navigation.setBorder(null);
        this.navigation.setBackground(Color.GRAY);
        this.navigation.setBounds(0, 46, 150, 376);
        contentPane.add(this.navigation);
        this.navigation.setLayout(null);

        this.storage = new JButton("Storage");
        this.storage.setBounds(28, 64, 91, 29);
        this.storage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(UserManagerGUI.this.contentPane);
                coreui.toggleStorageManager(user);
            }
        });
        navigation.add(this.storage);

        this.usersDb = new JButton("users DB");
        this.usersDb.setBounds(23, 23, 100, 29);
        this.usersDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(UserManagerGUI.this.contentPane);
                coreui.toggleUserManager(user);
            }
        });
        navigation.add(this.usersDb);

        this.logOutButton = new JButton("");
        this.logOutButton.setBounds(112, 342, 32, 28);
        this.logOutButton.setIcon(new ImageIcon("./images/logout.png"));
        this.logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(UserManagerGUI.this.contentPane);
                coreui.toggleLogin();
            }
        });
        navigation.add(this.logOutButton);


        this.pageTitle = new JLabel("User DB");
        this.pageTitle.setBounds(414, 61, 61, 16);
        contentPane.add(this.pageTitle);

        this.dataSection = new JPanel();
        this.dataSection.setBorder(null);
        this.dataSection.setBounds(151, 89, 649, 333);
        contentPane.add(this.dataSection);

        this.outerPanel = new JPanel(new BorderLayout());
        this.dataSection.add(this.outerPanel);
        this.outerPanel.add(this.rowHolderPanel, BorderLayout.PAGE_START);
        this.scrollPane = new JScrollPane(this.outerPanel);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.dataSection.setLayout(new BorderLayout());
        this.dataSection.add(this.scrollPane, BorderLayout.CENTER);


        for(User u : users){
            gereratePanels(u.getName(), u.getSurname(), u.getStatus(), u, user);
        }

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    private void gereratePanels(String Name, String Surname, String status, User user, User loggedUser){
        JPanel panel = new JPanel();
        JButton acceptButton = null;
        panel.add(new JLabel(Name + " " + Surname));
        panel.add(Box.createHorizontalStrut(25));
        if(status.equals("notAccepted")){
            panel.add(acceptButton = new JButton("Accept user"));
            JButton finalAcceptButton1 = acceptButton;
            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    user.setStatus("Accepted");
                    panel.remove(finalAcceptButton1);
                    CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(UserManagerGUI.this.contentPane);
                    coreui.toggleUserManager(loggedUser);
                }
            });
        }
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.rowHolderPanel.add(panel);
        this.rowHolderPanel.revalidate();
        this.rowHolderPanel.repaint();
    }

}


