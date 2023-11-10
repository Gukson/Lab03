package rental;

import rental.dao.StorageDao;
import rental.dao.UserDao;
import rental.data.User;
import rental.view.CoreUI;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/kuba/Documents/GitHub/Lab03/database/skirentDB.db");
            UserDao userDao = new UserDao(connection);
            StorageDao storageDao = new StorageDao(connection);
            CoreUI coreUI = new CoreUI(userDao, storageDao);
            coreUI.setVisible(true);
            coreUI.toggleLogin();
            //connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}