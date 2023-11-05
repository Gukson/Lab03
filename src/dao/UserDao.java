package dao;

import model.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User>{

    private List<User> users;

    public UserDao() {
        this.users = new ArrayList<>();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user, String[] params) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
