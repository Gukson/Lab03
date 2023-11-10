package rental.service.registration;

import rental.exceptions.CreationException;
import rental.exceptions.ValidationException;
import rental.dao.UserDao;
import rental.data.User;

import java.util.ArrayList;
import java.util.List;

public class Registration {

    private UserDao userDao;

    public Registration(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(String name, String surname, char[] password, String nickname){
        validate(name, surname, password, nickname);

        if(!isNicknameAvailable(nickname)){
            throw new CreationException();
        }

        userDao.create(new User(name,surname,nickname,password,"notAccepted"));

    }

    private boolean validate(String name, String surname, char[] password, String nickname) {
        List<String> fieldsWithErrors = new ArrayList<>();
        if (name.length() == 0) {
            fieldsWithErrors.add("name");
        } if (surname.length() == 0) {
            fieldsWithErrors.add("surname");
        }if(password.length == 0){
            fieldsWithErrors.add("password");
        }if(nickname.length() == 0){
            fieldsWithErrors.add("nickname");
        }
        if (fieldsWithErrors.isEmpty()) {
            return true;
        }
        throw new ValidationException(fieldsWithErrors);
    }

    private boolean isNicknameAvailable(String nickname){
        for(User u : userDao.getAll()){
            if(u.getNickname().equals(nickname)){
                return false;
            }
        }
        return true;
    }
}
