package com.example.springbean.db;

import lombok.Data;

import java.sql.Date;

@Data
public class Goddess {

    private Integer id;
    private String user_name;
    private Integer sex;
    private Integer age;
    private Date birthday; //注意用的是java.util.Date
    private String email;
    private String mobile;
    private String create_user;
    private String update_user;
    private Date create_date;
    private Date update_date;
    private Integer isDel;
    //getter setter方法。。。
}
