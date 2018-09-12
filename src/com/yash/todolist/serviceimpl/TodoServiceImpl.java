package com.yash.todolist.serviceimpl;

import com.yash.todolist.dao.TodoDao;
import com.yash.todolist.model.Todo;
import com.yash.todolist.model.User;
import com.yash.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDao todoDao;

    @Override
    public void saveTodo(Todo todo) {
        todoDao.insert(todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoDao.update(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoDao.deleteTodo(todo);
    }

    @Override
    public List<Todo> getTodos(User user) {
        return todoDao.list(user);
    }

    @Override
    public Todo getTodo(int id) {
        return todoDao.getTodoById(id);
    }
}
