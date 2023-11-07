package view.managerpanel;

import dao.StorageDao;
import model.data.User;
import view.CoreUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorageManagerGUI {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane, navBar, navigation, dataSection, outerPanel;
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));
    private JLabel NameSurname, role, logo, pageTitle;
    private JButton storage, usersDb,logOutButton;
    private JScrollPane scrollPane;

    public StorageManagerGUI(User user, StorageDao storageDao){
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.LIGHT_GRAY);
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(this.contentPane);
        this.contentPane.setLayout(null);

        this.navBar = new JPanel();
        this.navBar.setBorder(null);
        this.navBar.setBackground(Color.GRAY);
        this.navBar.setBounds(0, 0, 800, 45);
        this.contentPane.add(this.navBar);
        this.navBar.setLayout(null);

        this.NameSurname = new JLabel(user.getName() + " " + user.getSurname());
        this.NameSurname.setHorizontalAlignment(SwingConstants.RIGHT);
        this.NameSurname.setBounds(604, 6, 175, 16);
        this.navBar.add(this.NameSurname);

        this.role = new JLabel(user.getRole());
        this.role.setHorizontalAlignment(SwingConstants.CENTER);
        this.role.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
        this.role.setBounds(707, 23, 61, 16);
        this.navBar.add(role);

        this.logo = new JLabel("SKI RENT");
        this.logo.setHorizontalAlignment(SwingConstants.CENTER);
        this.logo.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
        this.logo.setBounds(204, 6, 408, 33);
        this.navBar.add(logo);

        this.navigation = new JPanel();
        this.navigation.setBorder(null);
        this.navigation.setBackground(Color.GRAY);
        this.navigation.setBounds(0, 46, 150, 376);
        this.contentPane.add(this.navigation);
        this.navigation.setLayout(null);

        this.storage = new JButton("Storage");
        this.storage.setBounds(28, 64, 91, 29);
        this.storage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(StorageManagerGUI.this.contentPane);
                coreui.toggleStorageManager(user);
            }
        });
        this.navigation.add(storage);

        this.usersDb = new JButton("users DB");
        this.usersDb.setBounds(23, 23, 100, 29);
        this.usersDb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(StorageManagerGUI.this.contentPane);
                coreui.toggleUserManager(user);
            }
        });
        this.navigation.add(this.usersDb);

        this.logOutButton = new JButton("");
        this.logOutButton.setBounds(112, 342, 32, 28);
        this.logOutButton.setIcon(new ImageIcon("./images/logout.png"));
        this.logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(StorageManagerGUI.this.contentPane);
                coreui.toggleLogin();
            }
        });
        this.navigation.add(this.logOutButton);


        this.pageTitle = new JLabel("Storage");
        this.pageTitle.setBounds(414, 61, 61, 16);
        this.contentPane.add(this.pageTitle);

        this.dataSection = new JPanel();
        this.dataSection.setBorder(null);
        this.dataSection.setBounds(151, 89, 649, 333);
        this.contentPane.add(this.dataSection);

        this.outerPanel = new JPanel(new BorderLayout());
        this.dataSection.add(this.outerPanel);
        this.outerPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
        this.scrollPane = new JScrollPane(outerPanel);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.dataSection.setLayout(new BorderLayout());
        this.dataSection.add(scrollPane, BorderLayout.CENTER);
        
//        for(User u : users){
//            gereratePanels(u.getName(), u.getSurname(), u.getStatus());
//        }
    }

    private void setContentPane(JPanel contentPane) {
    }


    private void gereratePanels(String Name, String Surname, String status){
//        JPanel panel = new JPanel();
//        panel.add(new JLabel(Name + " " + Surname));
//        panel.add(Box.createHorizontalStrut(25));
//        if(status.equals("notAccepted")){
//            panel.add(new JButton("Accept user"));
//        }
//        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
//
//        rowHolderPanel.add(panel);
//        rowHolderPanel.revalidate();
//        rowHolderPanel.repaint();
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
