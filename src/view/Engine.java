package view;

import view.CoreUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine implements ActionListener {
    private CoreUI coreUI;
    public void Engine(){
        JPanel jPanel = new JPanel();
        this.coreUI = new CoreUI(jPanel);
        this.coreUI.toggleRegister("");
        this.coreUI.setVisible(true);

    }

    public CoreUI getCoreUI() {
        return coreUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.coreUI.toggleLogin();
    }
}
