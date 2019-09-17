package com.johnpank.chapter9;

import com.johnpank.chapter9.model.Gamer;
import com.johnpank.chapter9.repository.GamerRepository;
import com.johnpank.chapter9.service.GamerService;
import com.johnpank.chapter9.service.GamerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

public class MainClass {


    public static void main(String[] args) {
        System.out.println("----- START -----");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.johnpank.chapter9.AppConfig.class);

        GamerService gamerService = (GamerService) context.getBean("gamerService");
        ELOCalculator eloCalculator = (ELOCalculator) context.getBean("eloCalc");

//        gamerService.saveGamer(new Gamer("John", 1100));
//        gamerService.saveGamer(new Gamer("Vasya", 1080));
//        gamerService.saveGamer(new Gamer("ivan", 900));

        //gamerService.deleteById(3l);
        //gamerService.deleteByName("john");

        for (Gamer gamer1 : gamerService.findAllGamersSortedByRating()){
            System.out.println(gamer1);
        }
        //region elo test
//        ELOCalculator eloCalculator = new ELOCalculator();
//        System.out.println(eloCalculator.calcRating(1800, 1800, false));
//        System.out.println(eloCalculator.calcRating(1750, 1800, true));
        //endregion

        context.close();
        System.out.println("----- STOP -----");
    }
}
