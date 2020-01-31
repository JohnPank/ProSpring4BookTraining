package com.johnpank.prospring4.chapter12;

import com.johnpank.prospring4.chapter12.config.AppConfig;
import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.entity.WorkerQualifications;
import com.johnpank.prospring4.chapter12.repository.WorkerRepository;
import com.johnpank.prospring4.chapter12.service.WorkerService;
import com.johnpank.prospring4.chapter12.service.WorkerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.GregorianCalendar;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        System.out.println("start");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        WorkerService workerService = (WorkerService) context.getBean("workerService");
//
//        Worker worker = new Worker();
//
//        worker.setName("Petya Kamyshkin");
//        worker.setQualification(WorkerQualifications.ENGINEER.getTitle());
//        worker.setEmail("peka@mrsk.ru");
//        worker.setPassword("qwerty");
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.set(2019,4,28);
//        worker.setExamdate(calendar.getTime());
//        workerService.save(worker);
//
//        worker = workerService.findByName("Petya Kamyshkin");
//        //workerService.delete(worker);
//
//        System.out.println(worker.getName());
//        System.out.println(WorkerQualifications.values());
//        System.out.println(worker.getEmail());
//        context.close();
        System.out.println("end");
    }
}
