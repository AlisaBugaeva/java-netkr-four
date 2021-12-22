package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class UserFromFileController {

    @GetMapping("/userFromFile")
    public String greetingForm(){
        return "userFromFile";
    }

    @PostMapping("/userFromFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        try {
                byte[] old= Files.readAllBytes(Paths.get("users.txt"));

                Files.write(Paths.get("users.txt"), file.getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get("users.txt"), "\n".getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "successfully";
    }

}
