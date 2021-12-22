package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/emailUser")
    public String greetingForm(){
        return "emailUser";
    }
    @PostMapping("/emailUser")
    public String submitEmail(HttpServletRequest request){
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String text = request.getParameter("text");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mymailforalice@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);

        return "message";
    }
}
