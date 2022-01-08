package com.example.ibf2021d13.controller;

import com.example.ibf2021d13.model.Contacts;
import com.example.ibf2021d13.model.User;
import com.example.ibf2021d13.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class ApplicationController {

    Contacts contacts = new Contacts();

    @Autowired
    private UserDao userDao;

    @PostMapping(path="/submit",
                consumes="application/x-www-form-urlencoded",
                produces = "text/html")
    public String submit(@ModelAttribute User user, Model model) throws IOException {
        String userId = contacts.idGenerator();
        user.setId(userId);
        userDao.saveUser(user);
        String message = "User data created!, UserId: " + userId;
        model.addAttribute("info", message);
        return "index";
    }

    @GetMapping("/contact/{id}")
    public String contact(@PathVariable String id,  Model model) throws IOException {
        model.addAttribute("userWithId", userDao.findUserById(id));
        return "contact";
    }

    @GetMapping("/contact/all")
    public String allContact(Model model){
        model.addAttribute("allUsers", userDao.findAllUsers());
        return "contact";
    }
}
