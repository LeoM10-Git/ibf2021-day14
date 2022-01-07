package com.example.ibf2021d13.controller;

import com.example.ibf2021d13.model.Contacts;
import com.example.ibf2021d13.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


@Controller
public class ApplicationController {
    @Value("${dataDir}")
    private String dataDir;

    Contacts contacts = new Contacts();

    @PostMapping(path="/submit",
                consumes="application/x-www-form-urlencoded",
                produces ="text/html")
    public String submit(@ModelAttribute User user, Model model) throws IOException {
        String fileName = contacts.fileNameGenerator();
        String path = dataDir + "/" + fileName + ".txt";
        System.out.println(path);
        File file = new File(path);
        Files.createFile(Paths.get(path));
        FileWriter writer = new FileWriter(file);
        writer.write(user.toString());
        writer.flush();
        writer.close();
        String message = "User data created!";
        model.addAttribute("info", message);
        return "index";
    }

    @GetMapping("/contact/{id}")
    public String contact(@PathVariable String id,  Model model) throws IOException {
        String queryFileName = id + ".txt";
        String path = dataDir + "/" + queryFileName;
        File file = new File(path);
        // the other method to create file by Path
        // File file = Paths.get(path).toFile();

        if (file.exists()){
            StringBuilder user = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line;
            while ((line = reader.readLine()) != null){
                user.append(line).append("\n");
            }
            model.addAttribute("user", user);
        }else{
            String message = "User data not found!";
            model.addAttribute("warning", message);
        }
        return "contact";
    }
}
