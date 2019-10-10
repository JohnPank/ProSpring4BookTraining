package com.johnpank.prospring4.chapter11.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("someScheduledTask")
public class SomeScheduledTask {

    //ever second
    //@Scheduled(fixedRate = 1000)

    //second(0-60) min(0-59) hour(0-23) dayOfMonth(1-31) month(1-12) dayOfWeek(0-6 Sunday to Saturday, 7 is also Sunday)
    @Scheduled(cron = "0 17 16 * * ?")//task to be executed at 16:17 every day of every month.
    public void sayHello(){
        System.out.println("Hello, world!!!" + Thread.currentThread().getName());
    }
}
