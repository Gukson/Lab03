package dao;

import model.data.Ski;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageDao implements Dao<Ski>{

    private List<Ski> skis;

    public StorageDao() {
        this.skis = new ArrayList<>();

    }

    @Override
    public Optional<Ski> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Ski> getAll() {
        return null;
    }

    @Override
    public Ski create(Ski ski) {
        return null;
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
