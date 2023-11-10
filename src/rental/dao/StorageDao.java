package rental.dao;

import rental.data.Ski;
import rental.data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageDao implements Dao<Ski>{

    private List<Ski> skis;
    private Connection connection;

    public StorageDao(Connection connection) {
        this.connection = connection;
        this.skis = new ArrayList<>();
    }

    @Override
    public Optional<Ski> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Ski> getAll() {

        try{
            Statement stmt = connection.createStatement();
            ResultSet skiSet = stmt.executeQuery("SELECT * FROM storage");
            skis.clear();
            while (skiSet.next()){
                skis.add(new Ski(skiSet.getString("model"),skiSet.getInt("length"),skiSet.getString("serialNumber") ,skiSet.getInt("price"),skiSet.getInt("userID")));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skis;
    }

    @Override
    public Ski create(Ski ski) {
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO storage (serialNumber,model,length,userID,price) VALUES (?,?,?,?,?)");
            stmt.setString(1,ski.getSerialNumber());
            stmt.setString(2,ski.getModel());
            stmt.setInt(3,ski.getLength());
            stmt.setInt(4,0);
            stmt.setInt(5,ski.getPrice());

            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ski;
    }

    @Override
    public Ski update(Ski ski, String[] params) {
        return null;
    }

    @Override
    public Ski delete(Ski ski) {
        return null;
    }

    public Ski updateID(Ski ski, Integer id) {
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE storage SET userID = (?) WHERE serialNumber = (?)");
            stmt.setInt(1, id);
            stmt.setString(2,ski.getSerialNumber());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ski;
    }
}
