package com.example.login.entity;

import java.util.List;

public class Users {

    List<String> users;

    public Users() {
    }

    public Users(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
