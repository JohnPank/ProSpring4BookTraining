package com.johnpank.chapter6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MorrNpcDAOIimpl npcDAOIimpl = (MorrNpcDAOIimpl) context.getBean("getDao");
        npcDAOIimpl.setDataSource((DataSource) context.getBean("dataSource"));

        System.out.println("All NPCs");
        List list = npcDAOIimpl.listMorrowindNPC();
        for (Object npc : list){
            System.out.println(npc);
        }

        System.out.println();
        System.out.println("NPC with id = 4");
        System.out.println(npcDAOIimpl.getMorrowindNPCById(4));

        System.out.println();
        System.out.println("Update NPC with id = 4");
        npcDAOIimpl.updateMorrowindNPC(4, "Vivek", "Danmer", 26);

        System.out.println();
        System.out.println("NPC with id = 4");
        System.out.println(npcDAOIimpl.getMorrowindNPCById(4));

        System.out.println();
        System.out.println("All NPCs");
        list = npcDAOIimpl.listMorrowindNPC();
        for (Object npc : list){
            System.out.println(npc);
        }


       // npcDAOIimpl.createMorrowindNPC("RaVir", "Khajit", 40);

        System.out.println("---------------end----------------");
    }
}
