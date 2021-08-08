package com.example.springbean.db;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String user_name;
    private String phone;

    public void insert(String name, long phone) {

    }
}

