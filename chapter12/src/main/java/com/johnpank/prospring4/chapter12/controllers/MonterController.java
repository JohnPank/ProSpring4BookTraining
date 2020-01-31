package com.johnpank.prospring4.chapter12.controllers;

import com.johnpank.prospring4.chapter12.entity.Message;
import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.service.MessageService;
import com.johnpank.prospring4.chapter12.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/monter")
public class MonterController {

    @Autowired
    MessageService messageService;

    @GetMapping("/send")
    public ModelAndView sendMesage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("str_message", new String());
        modelAndView.setViewName("send_message_page");
        return modelAndView;
    }

    @PostMapping("/message_handler")
    public @ResponseBody
    String handleMessage(@RequestParam String str_message){

        Message message = new Message();
        message.setDate_time(new Date());
        message.setStatus(str_message);

        message = messageService.save(message);

        return "message_handler working: message with ID " + message.getId() + " add to DB";
    }
}
