package com.yash.todolist.service;

import com.yash.todolist.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getUsers();
    User getUser(User user);
    User getUser(int id);
}

