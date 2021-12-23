package com.mycompany.controller;

import com.mycompany.model.SearchUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Controller
public class SearchController {
    @GetMapping("/searchUser")
    public String greetingForm(Model model){
        model.addAttribute("searchUser", new SearchUser());
        return "searchUser";
    }


    @PostMapping("/searchUser")
    public String searchResult(@ModelAttribute SearchUser searchUser, HttpServletRequest request) throws FileNotFoundException {
        searchUser.compareUsers();
        if(searchUser.answer != null && !searchUser.answer.trim().isEmpty()){
            return "result";
        }
        else
            return "noUser";
    }

}
