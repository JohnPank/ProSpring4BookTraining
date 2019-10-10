package com.johnpank.prospring4.chapter11;

import com.johnpank.prospring4.chapter11.config.AppConfig;
import com.johnpank.prospring4.chapter11.tasks.RunnableTask;
import com.johnpank.prospring4.chapter11.tasks.SomeAsyncTask;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(" ----- START ----- ");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SomeAsyncTask asyncTask = (SomeAsyncTask) context.getBean("someAsyncTask");
        System.out.println("this tread " + Thread.currentThread().getName());
        asyncTask.sayHelloFromAnotherThread();

        Future<String> result = asyncTask.sayPersonalHello("John");
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        SimpleAsyncTaskExecutor executor = (SimpleAsyncTaskExecutor) context.getBean("taskExecutor");
        executor.execute(new RunnableTask());


        //waiting crone
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        context.close();
        System.out.println(" ----- STOP ----- ");
    }
}
