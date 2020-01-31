package com.johnpank.prospring4.chapter12.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    Logger logger = Logger.getLogger(IndexController.class);

    @GetMapping
    public String mainPage(Model model){

        logger.debug("debug message - index controller");

        return "index";
    }

}
