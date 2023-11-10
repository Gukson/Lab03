package rental.view;

import rental.exceptions.LoginException;
import rental.exceptions.StatusException;
import rental.exceptions.ValidationException;
import rental.data.User;
import rental.service.login.Login;

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
    private Login login;
    private JLabel loginLabel, nicknameLabel,passwordLabel, errorLabel;
    private JTextField nicknameField;
    private JPasswordField passwordField;
    private ImageIcon hideIcon,showIcon;
    private JButton showHidePass,goToRegistrationButton,loginButton;

    public LoginGUI(Login login) {
        this.login = login;
        this.contentPane = new JPanel();
        this.contentPane.setLayout(null);
        this.contentPane.setBackground(new Color(192, 192, 192));

        JLabel skiImage = new JLabel("");
        skiImage.setBounds(63, 78, 316, 279);
        this.contentPane.add(skiImage);
        skiImage.setVerticalAlignment(SwingConstants.TOP);
        skiImage.setIcon(new ImageIcon("./images/ski-3.png"));

        this.loginLabel = new JLabel("Login");
        this.loginLabel.setFont(new Font("Myanmar MN", Font.BOLD, 37));
        this.loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.loginLabel.setBounds(480, 40, 240, 60);
        this.contentPane.add(this.loginLabel);

        this.nicknameField = new JTextField();
        this.nicknameField.setBounds(480, 115, 240, 35);
        this.contentPane.add(this.nicknameField);
        this.nicknameField.setColumns(10);

        this.nicknameLabel = new JLabel("Nickname");
        this.nicknameLabel.setBounds(485, 100, 70, 16);
        this.contentPane.add(this.nicknameLabel);

        this.passwordField = new JPasswordField();
        this.passwordField.setBounds(480, 165, 240, 35);
        this.contentPane.add(this.passwordField);

        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setBounds(485, 150, 61, 16);
        this.contentPane.add(this.passwordLabel);

        this.hideIcon = new ImageIcon("./images/hide.png");
        this.showIcon = new ImageIcon("./images/eye.png");

        this.showHidePass = new JButton("");
        this.showHidePass.addMouseListener(new MouseAdapter() {
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
        this.showHidePass.setIcon(hideIcon);
        this.showHidePass.setBounds(720, 165, 18, 35);
        this.showHidePass.setContentAreaFilled(false);
        this.showHidePass.setBorderPainted(false);
        this.showHidePass.setFocusPainted(false);
        this.contentPane.add(this.showHidePass);

        this.goToRegistrationButton = new JButton("Don't have an account? Sign up");
        this.goToRegistrationButton.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
        this.goToRegistrationButton.setForeground(new Color(0, 0, 0));
        this.goToRegistrationButton.setBounds(502, 202, 200, 20);
        this.goToRegistrationButton.setContentAreaFilled(false);
        this.goToRegistrationButton.setBorderPainted(false);
        this.goToRegistrationButton.setFocusPainted(true);
        goToRegistrationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(LoginGUI.this.contentPane);
                coreui.toggleRegister();
            }
        });
        this.contentPane.add(this.goToRegistrationButton);

        this.loginButton = new JButton("Login");
        this.loginButton.setIcon(null);
        this.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    User user = LoginGUI.this.login.login(nicknameField.getText(), passwordField.getPassword());
                    CoreUI coreui = (CoreUI) SwingUtilities.getWindowAncestor(LoginGUI.this.contentPane);
                    switch (user.getRole()) {
                        case "Client" ->
                            //go to client panel
                                coreui.toggleClientOfert(user);
                        case "Employee" ->
                            //go to employee panel
                                coreui.toggleEmployee(user);
                        case "Manager" -> {
                            coreui.toggleUserManager(user);
                        }
                    }

                }catch (ValidationException e2){
                    errorLabel.setText("Empty " + e2.toString());
                }catch (LoginException e3){
                    errorLabel.setText("Valid Nickname or Password");
                }
                catch (StatusException e4){
                    errorLabel.setText("Your account has not been verified yet");
                }
            }
        });
        this.loginButton.setBackground(new Color(255, 255, 255));
        this.loginButton.setBounds(539, 240, 120, 30);
        this.contentPane.add(this.loginButton);

        this.errorLabel = new JLabel("");
        this.errorLabel.setEnabled(false);
        this.errorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        this.errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.errorLabel.setForeground(new Color(255, 30, 0));
        this.errorLabel.setBounds(480, 222, 240, 16);
        this.contentPane.add(this.errorLabel);

    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
