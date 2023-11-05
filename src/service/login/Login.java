package service.login;

import dao.UserDao;
import exceptions.LoginException;
import exceptions.StatusException;
import exceptions.ValidationException;
import model.data.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login {
    private UserDao userDao;
    public Login(UserDao userDao) {
        this.userDao = userDao;
    }

    public void login(String nickname, char[] password){
        validate(nickname, password);
        checkData(nickname, password);
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

    private boolean checkData(String nickname, char[] password){
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
        return true;
    }
}
