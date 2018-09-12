package com.yash.todolist.dao;

import com.yash.todolist.model.Todo;
import com.yash.todolist.model.User;

import java.util.List;

public interface TodoDao {
    void insert(Todo todo);
    Todo getTodoById(int id);
    List<Todo> list(User user);
    void update(Todo todo);
    void deleteTodo(Todo todo);
}
