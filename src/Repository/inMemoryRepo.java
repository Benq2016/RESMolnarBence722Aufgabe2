package src.Repository;

import src.Domain.HasName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inMemoryRepo<T extends HasName> implements Repository<T> {
    private final Map<String, T> data = new HashMap<>();

    @Override
    public void add(T object) {
        data.put(object.getName(), object);
    }

    @Override
    public void remove(String name) {
        data.remove(name);
    }

    @Override
    public void update(T object) {
        data.replace(object.getName(), object);
    }

    @Override
    public T get(String name) {
        return data.get(name);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }
}
