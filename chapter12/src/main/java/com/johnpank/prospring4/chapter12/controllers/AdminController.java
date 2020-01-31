package com.johnpank.prospring4.chapter12.controllers;

import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    WorkerService workerService;

    @GetMapping("/monter/{Id}")
    public ModelAndView getWorkersById(@PathVariable("Id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("monter", workerService.findById(id));
        modelAndView.setViewName("monter_info_page");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView getWorkerList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("monter_list", workerService.findAll());
        modelAndView.setViewName("monter_list_page");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addMonterInDB(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("workerModel", new Worker());
        modelAndView.setViewName("add_worker_page");
        return modelAndView;
    }

    @PostMapping("/add_worker")
    public @ResponseBody
    String addMonter(@ModelAttribute("workerModel") Worker worker){
        Worker temp = workerService.save(worker);
        return "Worker with ID " + temp.getId() + " add to DataBase";
    }

//    public @ResponseBody List<Worker> getAllWorkers(){
//        return workerService.findAll();
//    }

}
