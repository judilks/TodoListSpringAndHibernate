package com.yash.todolist.resources;

public final class Queries {
    public final static String USER_INSERT = "insert into users (name, contact, email, joinDate) values (?,?,?,?)";
    public final static String TOTAL_USERS="select count(*) from users";
    public final static String GET_USER="select * from users where user_id=?";
}
