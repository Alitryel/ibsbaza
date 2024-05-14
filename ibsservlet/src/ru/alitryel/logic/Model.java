package ru.alitryel.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instanse = new Model();
    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instanse;
    }

    private Model() {
        model = new HashMap<>();
        model.put(1, new User("Tigran", "Kantashyan", 55555));
        model.put(2, new User("Anton", "Osipov", 66666));
        model.put(3, new User("Zoya", "Andreeva", 77777));
        model.put(4, new User("Dmitriy", "Sheremetev", 76654));
    }

    public void add(User user, int id) {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList() {
        return model;
    }

    public void delete(int id) {
        model.remove(id);
    }

    public void put(User user, int id) {
    }

}
