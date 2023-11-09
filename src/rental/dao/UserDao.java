package rental.dao;

import rental.data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User>{

    private List<User> users;
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
        this.users = new ArrayList<>();
        char[] password = new char[1];
        password[0] = 'r';

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
        try{
            Statement stmt = connection.createStatement();
            ResultSet usersSet = stmt.executeQuery("SELECT * FROM users");
            while (usersSet.next()){
                users.add(new User(usersSet.getString("Name"),usersSet.getString("Surname"),usersSet.getString("Nickname"), usersSet.getString("Password").toCharArray(), usersSet.getString("Status"),usersSet.getString("Role")));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
