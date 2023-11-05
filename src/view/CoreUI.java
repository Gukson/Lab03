package view;

import dao.UserDao;
import service.registration.Registration;

import javax.swing.*;
import java.awt.*;

public class CoreUI extends JFrame {

    private JPanel jpanel;
    private UserDao userDao;


    public CoreUI(UserDao userDao) {
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
        LoginGUI logingui = new LoginGUI();
        this.replaceView(logingui.getContentPane());
    }

    public void toggleRegister() {
        RegistrationGUI gui = new RegistrationGUI(new Registration(this.userDao));
        this.jpanel = gui.getRegisterPane();
        this.replaceView(this.jpanel);
    }

    public void toggleManager() {

    }

    public void toggleEmployee() {

    }

    public void toggleClient() {

    }

}