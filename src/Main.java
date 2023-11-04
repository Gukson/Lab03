import view.CoreUI;
import view.RegistrationGUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        CoreUI coreUI = new CoreUI(jPanel);
        coreUI.toggleRegister();

        coreUI.setVisible(true);
    }
}