package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private Boolean isHiden = true;

    public LoginGUI() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(192, 192, 192));

        JLabel skiImage = new JLabel("");
        skiImage.setBounds(63, 78, 316, 279);
        contentPane.add(skiImage);
        skiImage.setVerticalAlignment(SwingConstants.TOP);
        skiImage.setIcon(new ImageIcon("/Users/kuba/Downloads/ski-3.png"));

        JLabel registerLabel = new JLabel("Login");
        registerLabel.setFont(new Font("Myanmar MN", Font.BOLD, 37));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(480, 40, 240, 60);
        contentPane.add(registerLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(480, 115, 240, 35);
        contentPane.add(nameField);
        nameField.setColumns(10);

        JLabel nameLabel = new JLabel("Nickname");
        nameLabel.setBounds(485, 100, 70, 16);
        contentPane.add(nameLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(480, 165, 240, 35);
        contentPane.add(passwordField);

        ImageIcon hideIcon = new ImageIcon("/Users/kuba/Downloads/hide.png");
        ImageIcon showIcon = new ImageIcon("/Users/kuba/Downloads/eye.png");

        JButton showHidePass = new JButton("");
        showHidePass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isHiden) {
                    showHidePass.setIcon(showIcon);
                    passwordField.setEchoChar((char)0);
                    isHiden = false;

                }
                else {
                    showHidePass.setIcon(hideIcon);
                    passwordField.setEchoChar('*');
                    isHiden = true;

                }

            }
        });
        showHidePass.setIcon(hideIcon);
        showHidePass.setBounds(720, 165, 18, 35);
        showHidePass.setContentAreaFilled(false);
        showHidePass.setBorderPainted(false);
        showHidePass.setFocusPainted(false);
        contentPane.add(showHidePass);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(485, 150, 61, 16);
        contentPane.add(passwordLabel);

        JButton goToRegistrationButton = new JButton("Don't have an account? Sign up");
        goToRegistrationButton.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        goToRegistrationButton.setForeground(new Color(0, 0, 0));
        goToRegistrationButton.setBounds(502, 202, 200, 20);
        goToRegistrationButton.setContentAreaFilled(false);
        goToRegistrationButton.setBorderPainted(false);
        goToRegistrationButton.setFocusPainted(true);
        goToRegistrationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(LoginGUI.this.contentPane);
                coreui.toggleRegister("");
            }
        });
        contentPane.add(goToRegistrationButton);

        JButton loginButton = new JButton("Login");
        loginButton.setIcon(null);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setBounds(539, 234, 120, 30);
        contentPane.add(loginButton);

    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
