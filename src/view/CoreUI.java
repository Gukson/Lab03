package view;

import dao.StorageDao;
import dao.UserDao;
import model.data.User;
import service.login.Login;
import service.registration.Registration;
import view.managerpanel.UserManagerGUI;

import javax.swing.*;
import java.awt.*;

public class CoreUI extends JFrame {

    private JPanel jpanel;
    private UserDao userDao;

    public CoreUI(UserDao userDao, StorageDao storageDao) {
        this.userDao = userDao;
        setBackground(new Color(192, 192, 192));
        setResizable(false);
        setAutoRequestFocus(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 450);
    }

    public void replaceView(JPanel jPanel) {
        this.jpanel = jPanel;
        setContentPane(this.jpanel);
        this.revalidate();
    }

    public void toggleLogin(){
        LoginGUI logingui = new LoginGUI(new Login(this.userDao));
        this.replaceView(logingui.getContentPane());
    }

    public void toggleRegister() {
        RegistrationGUI gui = new RegistrationGUI(new Registration(this.userDao));
        this.jpanel = gui.getRegisterPane();
        this.replaceView(this.jpanel);
    }

    public void toggleManager(User user) {
        UserManagerGUI gui = new UserManagerGUI(userDao.getUsers(), user);
        this.jpanel = gui.getContentPane();
        this.replaceView(this.jpanel);
    }

    public void toggleEmployee() {

    }

    public void toggleClient() {

    }

}