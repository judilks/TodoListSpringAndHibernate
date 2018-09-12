package com.yash.todolist.serviceimpl;

import com.yash.todolist.dao.UserDao;
import com.yash.todolist.model.User;
import com.yash.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUser(User user) {
        return userDao.getUserByCredentials(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.list();
    }

}
