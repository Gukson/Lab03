package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoreUI extends JFrame {

    private JPanel jpanel;

    public CoreUI(JPanel jPanel) {
        this.jpanel = jPanel;
        setBackground(new Color(192, 192, 192));
        setResizable(false);
        setAutoRequestFocus(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 450);

        setContentPane(this.jpanel);
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

    public void toggleRegister(String string) {
        RegistrationGUI gui = new RegistrationGUI(string);
        this.replaceView(gui.getRegisterPane());
    }

    public void toggleManager() {

    }

    public void toggleEmployee() {

    }

    public void toggleClient() {

    }

}