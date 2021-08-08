package com.mason.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User use) {
        // TODO Auto-generated method stub
        jdbcTemplate.update("insert into user (id,name) values(?,?)", use.getName());
    }
}
