import dao.StorageDao;
import dao.UserDao;
import view.CoreUI;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        StorageDao storageDao = new StorageDao();
        CoreUI coreUI = new CoreUI(userDao, storageDao);
        coreUI.setVisible(true);
        coreUI.toggleLogin();
    }
}