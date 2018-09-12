package com.yash.todolist.controller;

import com.yash.todolist.model.User;
import com.yash.todolist.service.TodoService;
import com.yash.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    TodoService todoService;

    @RequestMapping("/authenticate")
    public ModelAndView registrationProcessing(@ModelAttribute User user, BindingResult result){
        User authenticatedUser = userService.getUser(user);
        if(result.hasErrors() || authenticatedUser == null){
            return new ModelAndView("login");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("todos", user.getTodos());
        map.put("user", authenticatedUser);
        return new ModelAndView("welcome", map);
    }

    @RequestMapping("/loginform")
    public String loginForm(){
        return "login";
    }


}
