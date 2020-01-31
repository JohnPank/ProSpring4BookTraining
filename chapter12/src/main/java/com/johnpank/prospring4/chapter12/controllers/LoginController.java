package com.johnpank.prospring4.chapter12.controllers;

import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/login")
    public ModelAndView validateMonter(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("workerModel", new Worker());
        modelAndView.setViewName("login_page");
        return modelAndView;
    }

    @PostMapping("/check")
    public @ResponseBody
    String checkMonter(@ModelAttribute("workerModel") Worker worker){

        if (worker.getName() != "") {
            Worker tempMonter = workerService.findByName(worker.getName());
            if (tempMonter.getPassword().equals(worker.getPassword())){
                return "Validate";
            }else {
                return "Get out, ass hole!";
            }
        }else{
            return "Please input name and email";
        }

    }

}
