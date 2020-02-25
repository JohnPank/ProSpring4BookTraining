package com.johnpank.prospring4.chapter13.controllers;

import com.johnpank.prospring4.chapter13.entity.User;
import com.johnpank.prospring4.chapter13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getIndexPage(Model model){
        return "index-page";
    }

    @GetMapping("/add")
    public ModelAndView addUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("add-page");
        return modelAndView;
    }

    @PostMapping("/addToBase")
    public @ResponseBody
    String addUser(@ModelAttribute("user") User user){
        //check notNull and not empty
        if (user.getEmail() != "" && user.getName() != "" && user.getPassword() != "" &&
                user.getEmail() != null && user.getName() != null && user.getPassword() != null){
            userService.save(user);
            return "User saved!";
        }else {
            return "User no save";
        }
    }

    @GetMapping("/list")
    public ModelAndView getAllUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userService.findAll());
        modelAndView.setViewName("list-page");
        return modelAndView;
    }

}

