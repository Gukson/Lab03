import dao.UserDao;
import view.CoreUI;

public class Main {
    public static void main(String[] args) {
        //Registration registration = new Registration();
        //RegistrationGUI registrationGUI = new RegistrationGUI(registration);
        UserDao userDao = new UserDao();
        CoreUI coreUI = new CoreUI(userDao);
        coreUI.setVisible(true);
        coreUI.toggleRegister();
    }
}