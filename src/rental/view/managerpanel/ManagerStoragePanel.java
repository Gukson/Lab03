package rental.view.managerpanel;

import rental.dao.StorageDao;
import rental.dao.UserDao;
import rental.data.Ski;
import rental.data.User;
import rental.view.CoreUI;
import rental.view.employeepanel.EmployeeReservedGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerStoragePanel {
    public void StoragePanel(Ski ski, UserDao userDao, StorageDao storageDao, User loggedUser, StorageManagerGUI managerStoragePanel, JPanel rowHolderPanel){
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

        JButton delete = new JButton("delete");
        delete.setBounds(452, 57, 142, 29);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storageDao.removeReservation(ski);
                storageDao.delete(ski);
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(managerStoragePanel.getContentPane());
                coreui.toggleStorageManager(loggedUser);
            }
        });
        panel.add(delete);


        JLabel skiImageLabel = new JLabel("");
        skiImageLabel.setIcon(new ImageIcon("./images/ski.png"));
        skiImageLabel.setBounds(6, 6, 90, 80);
        panel.add(skiImageLabel);

        JLabel nameLabel = new JLabel();
        nameLabel.setBounds(76, 6, 170, 16);
        if(ski.getUserID() == 0){
            nameLabel.setText("Name: none");
        }
        else {
            User user = userDao.getUserByID(ski.getUserID());
            nameLabel.setText("Name: " + user.getName() + " " + user.getSurname());
        }
        panel.add(nameLabel);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        rowHolderPanel.add(panel);
        rowHolderPanel.revalidate();
        rowHolderPanel.repaint();
    }

}
