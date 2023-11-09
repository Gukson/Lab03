package view.clientpanel;

import dao.StorageDao;
import exceptions.CreationException;
import model.data.Ski;
import model.data.User;
import service.reservation.Reserve;
import view.CoreUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientGUI {
    private JPanel contentPane, navBar, navigation, dataSection, outerPanel;
    private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));
    private JLabel NameSurname, role, logo, pageTitle, messageLabel;
    private JButton ofert, myReservation, logOutButton;
    private JScrollPane scrollPane;
    private Reserve reserve;

    public ClientGUI(User loggedUser, StorageDao storageDao, Reserve reserve){
        this.reserve = reserve;
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

        this.NameSurname = new JLabel(loggedUser.getName() + " " + loggedUser.getSurname());
        this.NameSurname.setHorizontalAlignment(SwingConstants.RIGHT);
        this.NameSurname.setBounds(604, 6, 175, 16);
        this.navBar.add(this.NameSurname);

        this.role = new JLabel(loggedUser.getRole());
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

        this.ofert = new JButton("Ofert");
        this.ofert.setBounds(28, 64, 91, 29);
        this.ofert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(ClientGUI.this.contentPane);
//                coreui.toggleClientOfert(loggedUser);
                rowHolderPanel.removeAll();
                pageTitle.setText("Ofert");
                for(Ski s : storageDao.getAll()){
                    if(s.getActualOwner() == null){
                        generateSkiPanels(s, loggedUser, messageLabel);
                    }
                }


            }
        });
        this.navigation.add(ofert);

        this.myReservation = new JButton("My Resevation");
        this.myReservation.setBounds(13, 23, 120, 29);
        this.myReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(StorageManagerGUI.this.contentPane);
//                coreui.toggleUserManager(loggedUser);
                rowHolderPanel.removeAll();
                pageTitle.setText("My Reservation");
                for(Ski s : storageDao.getAll()){
                    if(s.getActualOwner() == loggedUser){
                        generateSkiPanels(s, loggedUser, messageLabel);
                    }
                }

            }
        });
        this.navigation.add(this.myReservation);

        this.logOutButton = new JButton();
        this.logOutButton.setBounds(112, 342, 32, 28);
        this.logOutButton.setIcon(new ImageIcon("./images/logout.png"));
        this.logOutButton.setOpaque(false);
        this.logOutButton.setContentAreaFilled(false);
        this.logOutButton.setBorderPainted(false);
        this.logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(ClientGUI.this.contentPane);
                coreui.toggleLogin();
            }
        });
        this.navigation.add(this.logOutButton);

        this.pageTitle = new JLabel("Ofert");
        this.pageTitle.setBounds(396, 54, 100, 16);
        this.contentPane.add(this.pageTitle);

        this.messageLabel = new JLabel();
        this.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.messageLabel.setBounds(162, 70, 533, 16);
        this.contentPane.add(this.messageLabel);

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



        for(Ski s : storageDao.getAll()){
            if(s.getActualOwner() == null){
                generateSkiPanels(s, loggedUser, this.messageLabel);
            }
        }

    }
    private void generateSkiPanels(Ski ski, User loggedUser, JLabel messageLabel){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("S/N: " + ski.getSerialNumber() + " | ", SwingConstants.LEFT));
        panel.add(new JLabel("l: " + ski.getLength() + "cm | ", SwingConstants.LEFT));
        panel.add(new JLabel("Model: " + ski.getModel() + " | ", SwingConstants.LEFT));
        panel.add(new JLabel("Price: " + ski.getPrice() + " | ", SwingConstants.LEFT));

        JButton reserveBT = new JButton("Reserve");
        panel.add(reserveBT);
        reserveBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ClientGUI.this.reserve.reservation(ski,loggedUser);
                    panel.remove(reserveBT);
                    CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(ClientGUI.this.contentPane);
                    coreui.toggleClientOfert(loggedUser);
                    messageLabel.setText("Succesfully reserved");
                    messageLabel.setForeground(Color.GREEN);
                }catch (CreationException e2){
                    messageLabel.setText("Reservation error");
                    messageLabel.setForeground(Color.RED);
                }
            }
        });

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        rowHolderPanel.add(panel);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}