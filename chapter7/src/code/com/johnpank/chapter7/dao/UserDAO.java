package code.com.johnpank.chapter7.dao;

import code.com.johnpank.chapter7.models.User;
import com.sun.istack.internal.NotNull;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDAO implements DAO<User, Integer> {

    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public UserDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(@NotNull final User user) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public User read(@NotNull final Integer id) {
        try (final Session session = factory.openSession()) {

            final User result = session.get(User.class, id);
            if (result != null) {
                Hibernate.initialize(result.getNotes());
            }

            return result != null ? result : new User();
        }
    }

    @Override
    public void update(@NotNull final User user) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final User user) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
        }
    }
}

