package com.mason.sql;

public class User {
    private Integer id;
    private String name;
    public User(String name2) {
        // TODO Auto-generated constructor stub
        this.name = name2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
