package view;

import service.registration.Registration;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistrationGUI{
    private static final long serialVersionUID = 1L;
    private JPanel registerPane;
    private JTextField nameField;
    private JTextField surnameField;
    private JPasswordField passwordField;
    private JTextField nicnameField;
    private JLabel errorLabel;

    private Boolean isHiden = true;
    public RegistrationGUI(String errorMessage) {
        registerPane = new JPanel();
        registerPane.setBackground(new Color(192, 192, 192));
        registerPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        registerPane.setLayout(null);

        JButton registerButton = new JButton("Register");
        registerButton.setIcon(null);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registration register = new Registration();
                CoreUI coreUI = (CoreUI) SwingUtilities.getWindowAncestor(RegistrationGUI.this.registerPane);
                register.register(nameField.getText(), surnameField.getText(),passwordField.getPassword(), nicnameField.getText(), coreUI);
            }
        });
        registerButton.setBackground(new Color(255, 255, 255));
        registerButton.setBounds(540, 360, 120, 30);
        registerPane.add(registerButton);

        JLabel registerLabel = new JLabel("Registration");
        registerLabel.setFont(new Font("Myanmar MN", Font.BOLD, 37));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(480, 40, 240, 60);
        registerPane.add(registerLabel);

        JLabel skiImage = new JLabel("");
        skiImage.setBounds(63, 78, 316, 279);
        registerPane.add(skiImage);
        skiImage.setVerticalAlignment(SwingConstants.TOP);
        skiImage.setIcon(new ImageIcon("./images/ski-3.png"));

        nameField = new JTextField();
        nameField.setBounds(480, 115, 240, 35);
        registerPane.add(nameField);
        nameField.setColumns(10);

        surnameField = new JTextField();
        surnameField.setColumns(10);
        surnameField.setBounds(480, 165, 240, 35);
        registerPane.add(surnameField);

        JComboBox<String[]> genderComboBox = new JComboBox();
        genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
        genderComboBox.setBounds(480, 305, 120, 27);
        registerPane.add(genderComboBox);

        JButton goToLoginButton = new JButton("Already have an account? Log in");
        goToLoginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        goToLoginButton.setForeground(new Color(0, 0, 0));
        goToLoginButton.setBounds(505, 345, 200, 20);
        goToLoginButton.setContentAreaFilled(false);
        goToLoginButton.setBorderPainted(false);
        goToLoginButton.setFocusPainted(true);
        Font font = goToLoginButton.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        goToLoginButton.setFont(font.deriveFont(attributes));
        goToLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(RegistrationGUI.this.registerPane);
                coreui.toggleLogin();
            }
        });
        registerPane.add(goToLoginButton);

        JLabel nameLabel = new JLabel("First name");
        nameLabel.setBounds(485, 100, 75, 16);
        registerPane.add(nameLabel);

        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(485, 150, 61, 16);
        registerPane.add(surnameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(485, 250, 61, 16);
        registerPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(480, 265, 240, 35);
        registerPane.add(passwordField);

        ImageIcon hideIcon = new ImageIcon("./images/hide.png");
        ImageIcon showIcon = new ImageIcon("./images/eye.png");


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
        showHidePass.setBounds(720, 265, 18, 35);
        showHidePass.setContentAreaFilled(false);
        showHidePass.setBorderPainted(false);
        showHidePass.setFocusPainted(false);
        registerPane.add(showHidePass);

        nicnameField = new JTextField();
        nicnameField.setBounds(480, 215, 240, 35);
        registerPane.add(nicnameField);

        JLabel nicknameLabel = new JLabel("Nickname");
        nicknameLabel.setBounds(485, 200, 80, 16);
        registerPane.add(nicknameLabel);

        errorLabel = new JLabel(errorMessage);
        //errorLabel.setEnabled(false);
        errorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(new Color(255, 30, 0));
        errorLabel.setBounds(480, 332, 240, 16);
        registerPane.add(errorLabel);
    }

    JPanel getRegisterPane() {
        return this.registerPane;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
}
