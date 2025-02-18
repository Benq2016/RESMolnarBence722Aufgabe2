package src.Repository;

import java.util.List;

public interface Repository<T>{
    void add(T object);
    void remove(String id);
    void update(T object);
    T get(String id);
    List<T> getAll();
}
