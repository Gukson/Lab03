package rental.view.clientpanel;

import rental.dao.StorageDao;
import rental.data.Ski;
import rental.data.User;
import rental.view.CoreUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyReservationsPanel {

    public void MyReservationsPanel(Ski ski, StorageDao storageDao, User loggedUser, ClientReservationsGUI clientGUI, JPanel rowHolderPanel){
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
        modelLabel.setBounds(262, 29, 150, 16);
        panel.add(modelLabel);

        JLabel lengthLabel = new JLabel("Length: " +ski.getLength() + " cm");
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lengthLabel.setBounds(262, 50, 150, 16);
        panel.add(lengthLabel);

        JLabel priceLabel = new JLabel("Price: " + ski.getPrice() + "zł");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setBounds(262, 70, 150, 16);
        panel.add(priceLabel);

        JButton payButton = new JButton("Pay");
        payButton.setBounds(452, 29, 67, 29);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storageDao.update(ski,new String[]{"isPaid", "1"});
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(clientGUI.getContentPane());
                coreui.toggleClientReservations(loggedUser);
            }
        });
        if(ski.isPaid() == 0){
            panel.add(payButton);
        }

        JButton cancelButton = new JButton("cancel");
        cancelButton.setBounds(452, 57, 142, 29);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storageDao.updateID(ski,0);
                storageDao.update(ski,new String[]{"Status", "Free"});
                storageDao.update(ski,new String[]{"isPaid", "0"});
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(clientGUI.getContentPane());
                coreui.toggleClientReservations(loggedUser);
            }
        });
        panel.add(cancelButton);


        JLabel isPayedLabel = new JLabel();
        isPayedLabel.setBounds(444, 6, 150, 16);
        isPayedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if(ski.isPaid() == 0){
            isPayedLabel.setText("Reservation not paid");
            isPayedLabel.setForeground(Color.RED);
        }else {
            isPayedLabel.setText("Reservation paid");
            isPayedLabel.setForeground(Color.GREEN);
        }
        panel.add(isPayedLabel);

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
