package code.com.johnpank.chapter7;

import code.com.johnpank.chapter7.dao.UserDAO;
import code.com.johnpank.chapter7.models.Note;
import code.com.johnpank.chapter7.models.User;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class mainClass {

    public static void main(String[] args) {
        System.out.println("start");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        try{
            UserDAO userDAO = new UserDAO(sessionFactory);

//          userDAO.create(user);

            int userID = 3;
            User user = userDAO.read(userID);

            Note note = new Note();
            note.setUserId(userID);
            note.setContent("test note bu user " + userID);
            note.setAddDate(new Date());

            Set notes = new HashSet();
            notes.add(note);
            user.setNotes(notes);
            userDAO.update(user);
            user = userDAO.read(userID);


            System.out.println();
            System.out.println("------------------");

            System.out.println(user);
            Note[] notesAr = user.getNotes().toArray(new Note[0]);
            for (int i = 0; i < user.getNotes().size(); i++) {
                System.out.println(notesAr[i]);
            }

            System.out.println("------------------");
            System.out.println();

        }finally {
            sessionFactory.close();
        }

        System.out.println("end");
    }
}