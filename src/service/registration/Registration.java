package service.registration;

import model.data.User;
import service.UserDao;
import view.CoreUI;
import view.Engine;
import view.RegistrationGUI;

import java.util.EmptyStackException;

public class Registration {

    public void register(String name, String surname, char[] password, String nickname, CoreUI coreUI){

        if(name.length() == 0 || surname.length() == 0 || password.length == 0 || nickname.length() == 0){
            coreUI.toggleRegister("All gapes schould be filled");

        }

        coreUI.toggleLogin();


    }

}
