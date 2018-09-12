package com.yash.todolist.service;


import com.yash.todolist.model.Todo;
import com.yash.todolist.model.User;

import java.util.List;

public interface TodoService {

    void saveTodo(Todo todo);
    void updateTodo(Todo todo);
    void deleteTodo(Todo todo);
    List<Todo> getTodos(User user);
    Todo getTodo(int id);

}
