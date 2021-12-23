package com.mycompany.controller;

import com.mycompany.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @GetMapping("/user")
    public String greetingForm(Model model){
        model.addAttribute("user", new User());

        return "user";
    }

    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute User user) {
        user.writingUser();

        return "successfully";
    }
    }

