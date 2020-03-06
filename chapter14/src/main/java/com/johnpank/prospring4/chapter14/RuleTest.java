package com.johnpank.prospring4.chapter14;

import com.johnpank.prospring4.chapter14.config.AppConfig;
import com.johnpank.prospring4.chapter14.interfaces.UnitService;
import com.johnpank.prospring4.chapter14.model.Unit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RuleTest extends Rule {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UnitService unitService = (UnitService) context.getBean("unitService");

        Unit unit = new Unit("slave", 2, 3, 5, "");

        System.out.println("Before appling rule");
        System.out.println(unit);

        unitService.applyRule(unit);

        System.out.println("after appling rule");
        System.out.println(unit);
    }
}
