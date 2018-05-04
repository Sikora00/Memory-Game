package Entities;

import Interfaces.Serializable;

public class User implements Serializable<User> {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
