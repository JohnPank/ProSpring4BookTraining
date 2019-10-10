package com.johnpank.prospring4.chapter11.tasks;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component("someAsyncTask")
public class SomeAsyncTask {

    @Async
    public void sayHelloFromAnotherThread(){
        System.out.println("start someAsyncTask");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, world, from another thread " + Thread.currentThread().getName());
    }

    @Async
    public Future<String> sayPersonalHello(String name){
        AsyncResult<String> result = new AsyncResult<String>("Hello, " + name);
        return result;
    }
}
