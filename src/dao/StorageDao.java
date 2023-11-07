package dao;

import model.data.Good;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageDao implements Dao<Good>{

    private List<Good> goods;

    public StorageDao() {
        this.goods = new ArrayList<>();

    }

    @Override
    public Optional<Good> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Good> getAll() {
        return null;
    }

    @Override
    public Good create(Good good) {
        return null;
    }

    @Override
    public Good update(Good good, String[] params) {
        return null;
    }

    @Override
    public Good delete(Good good) {
        return null;
    }
}
