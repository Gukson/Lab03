package rental.dao;

import rental.data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        try{
            Statement stmt = connection.createStatement();
            ResultSet usersSet = stmt.executeQuery("SELECT * FROM users");
            users.clear();
            while (usersSet.next()){
                users.add(new User(usersSet.getString("Name"),usersSet.getString("Surname"),usersSet.getString("Nickname"), usersSet.getString("Password").toCharArray(), usersSet.getString("Status"),usersSet.getString("Role"), usersSet.getInt("id")));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public User create(User user) {
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (Name,Surname,Status,Role,Password,Nickname) VALUES (?,?,?,?,?,?)");
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getSurname());
            stmt.setString(3,user.getStatus());
            stmt.setString(4,user.getRole());
            stmt.setString(5,new String(user.getPassword()));
            stmt.setString(6, user.getNickname());

            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public User update(User user, String[] params) {
        try{
            PreparedStatement stmt;
            if(Objects.equals(params[0], "Status")){
                stmt = connection.prepareStatement("UPDATE users SET Status = (?) WHERE Nickname = (?)");
                stmt.setString(1,params[1]);
                stmt.setString(2,user.getNickname());
            }else{
                stmt = connection.prepareStatement("UPDATE users SET Role = (?) WHERE Nickname = (?)");
            }

            //stmt.setString(1,params[0]);

            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User delete(User user) {
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE Nickname = (?)");
            stmt.setString(1,user.getNickname());
            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User getUserByID(Integer id){
        User user = null;
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE id = (?)");
            stmt.setInt(1,id);
            ResultSet usersSet = stmt.executeQuery();
            user = new User(usersSet.getString("Name"),usersSet.getString("Surname"),usersSet.getString("Nickname"), usersSet.getString("Password").toCharArray(), usersSet.getString("Status"),usersSet.getString("Role"), usersSet.getInt("id"));

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}
