package com.johnpank.prospring4.chapter12.controllers;

import com.johnpank.prospring4.chapter12.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/disp")
public class DispatcherController {

    @Autowired
    MessageService messageService;

    @GetMapping("/list")
    public ModelAndView getMessageList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message_list", messageService.findAll());
        modelAndView.setViewName("message_list_page");
        return modelAndView;
    }
}
