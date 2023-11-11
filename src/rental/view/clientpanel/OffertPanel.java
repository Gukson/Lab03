package rental.view.clientpanel;

import rental.dao.StorageDao;
import rental.dao.UserDao;
import rental.data.Ski;
import rental.data.User;
import rental.exceptions.CreationException;
import rental.service.reservation.Reserve;
import rental.view.CoreUI;
import rental.view.employeepanel.EmployeeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OffertPanel {
    public void offerPanel(Ski ski, StorageDao storageDao, User loggedUser, ClientGUI clientGUI, JPanel rowHolderPanel, Reserve reserve){
        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,94);
        panel.setPreferredSize(new Dimension(600,94));
        panel.setLayout(null);

        JLabel serialNumberLabel = new JLabel("S/N: " + ski.getSerialNumber());
        serialNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        serialNumberLabel.setBounds(262, 6, 150, 16);
        panel.add(serialNumberLabel);

        JLabel modelLabel = new JLabel("Model: " + ski.getModel());
        modelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modelLabel.setBounds(262, 34, 150, 16);
        panel.add(modelLabel);

        JLabel lengthLabel = new JLabel("length: " +ski.getLength() + " cm");
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lengthLabel.setBounds(262, 62, 150, 16);
        panel.add(lengthLabel);

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setBounds(452, 57, 142, 29);
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    reserve.reservation(ski,storageDao,loggedUser);
                    panel.remove(reserveButton);
                    CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(clientGUI.getContentPane());
                    coreui.toggleClientOfert(loggedUser);
                }catch (CreationException e2){
                    //ewentualny error message na ekranie
                }
            }
        });
        panel.add(reserveButton);


        JLabel skiImageLabel = new JLabel("");
        skiImageLabel.setIcon(new ImageIcon("./images/ski.png"));
        skiImageLabel.setBounds(6, 6, 90, 80);
        panel.add(skiImageLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        rowHolderPanel.add(panel);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }
}
