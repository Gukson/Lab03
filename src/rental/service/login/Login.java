package rental.service.login;

import rental.dao.UserDao;
import rental.exceptions.LoginException;
import rental.exceptions.StatusException;
import rental.exceptions.ValidationException;
import rental.data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login {
    private UserDao userDao;
    public Login(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String nickname, char[] password){
        validate(nickname, password);
        User user = checkData(nickname, password);
        return user;
    }

    private boolean validate(String nickname, char[] password) {
        List<String> fieldsWithErrors = new ArrayList<>();

        if (nickname.length() == 0) {
            fieldsWithErrors.add("nickname");
        }
        if (password.length == 0) {
            fieldsWithErrors.add("password");
        }
        if(fieldsWithErrors.isEmpty()){
            return true;
        }
        throw new ValidationException(fieldsWithErrors);
    }

    private User checkData(String nickname, char[] password){
        boolean nicknameExist = false;
        User user = null;
        for(User u: userDao.getUsers()){
            if(u.getNickname().equals(nickname)){
                nicknameExist = true;
                user = u;
            }
        }
        if(!nicknameExist || !Arrays.equals(user.getPassword(), password)){
            throw new LoginException();
        }
        if(!user.getStatus().equals("Accepted")){
            throw new StatusException();
        }
        return user;
    }


}
