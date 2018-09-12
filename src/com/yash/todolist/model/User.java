package com.yash.todolist.model;


import javax.persistence.*;
import java.util.List;
@Entity
public class User {

    private int id;
    private String username;
    private String password;

    private List<Todo> todos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id")
    public List<Todo> getTodos() {
        return todos;
    }


    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
