package rental.dao;

import rental.data.Ski;

import java.sql.Connection;
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
        return skis;
    }

    @Override
    public Ski create(Ski ski) {
        skis.add(ski);
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
}
