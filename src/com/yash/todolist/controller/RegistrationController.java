package com.yash.todolist.controller;

import com.yash.todolist.model.User;
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
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String registrationProcessing(@ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        userService.saveUser(user);
        return "welcome";
    }

    @RequestMapping("/registerform")
    public String registrationForm(){
        return "register";
    }

}
