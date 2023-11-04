package service;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    Optional<T> get(long id);
    List<T> getAll();
    T create(T t);
    T update(T t, String[] params);
    T delete(T t);

}
