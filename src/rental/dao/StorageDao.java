package rental.dao;

import rental.data.Ski;
import rental.data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
            stmt.setQueryTimeout(5);
            ResultSet skiSet = stmt.executeQuery("SELECT * FROM storage");
            skis.clear();
            while (skiSet.next()){
                skis.add(new Ski(skiSet.getString("model"),skiSet.getInt("length"),skiSet.getString("serialNumber") ,skiSet.getInt("price"),skiSet.getInt("userID"),skiSet.getString("status"),skiSet.getInt("isPaid")));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return skis;
    }

    @Override
    public Ski create(Ski ski) {
        try{
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO storage (serialNumber,model,length,userID,price,status,isPaid) VALUES (?,?,?,?,?,?,?)");
            stmt.setQueryTimeout(5);
            stmt.setString(1,ski.getSerialNumber());
            stmt.setString(2,ski.getModel());
            stmt.setInt(3,ski.getLength());
            stmt.setInt(4,0);
            stmt.setInt(5,ski.getPrice());
            stmt.setString(6,"Free");
            stmt.setInt(7,ski.isPaid());

            stmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ski;
    }

    @Override
    public Ski update(Ski ski, String[] params) {
        try{
            PreparedStatement stmt;
            if(Objects.equals(params[0], "Status")){
                stmt = connection.prepareStatement("UPDATE storage SET status = (?) WHERE serialNumber = (?)");
                stmt.setQueryTimeout(5);
                stmt.setString(1,params[1]);
                stmt.setString(2,ski.getSerialNumber());
            }else {
                stmt = connection.prepareStatement("UPDATE storage SET isPaid = (?) WHERE serialNumber = (?)");
                stmt.setQueryTimeout(5);
                stmt.setInt(1, Integer.parseInt(params[1]));
                stmt.setString(2, ski.getSerialNumber());
            }

            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return ski;
    }

    @Override
    public Ski delete(Ski ski) {
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM storage WHERE serialNumber = (?)");
            stmt.setQueryTimeout(5);
            stmt.setString(1,ski.getSerialNumber());
            stmt.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ski;
    }

    public Ski updateID(Ski ski, Integer id) {
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE storage SET userID = (?) WHERE serialNumber = (?)");
            stmt.setQueryTimeout(5);
            stmt.setInt(1, id);
            stmt.setString(2,ski.getSerialNumber());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ski;
    }

    public Ski removeReservation(Ski ski){
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE storage SET userID = (?) WHERE userID = (?)");
            stmt.setQueryTimeout(5);
            stmt.setInt(1, 0);
            stmt.setString(2,ski.getSerialNumber());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ski;
    }
}
