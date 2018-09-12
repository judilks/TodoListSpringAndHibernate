package com.yash.todolist.dao;

import com.yash.todolist.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    User getUserByCredentials(User user);
    List<User> list();
    void update(User user);
    void deleteUser(User user);
    User getUserById(int id);

}
