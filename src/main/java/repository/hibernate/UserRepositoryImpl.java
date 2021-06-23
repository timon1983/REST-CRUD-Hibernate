package repository.hibernate;

import model.Event;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.UserRepository;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getById(Long id) {
        Transaction transaction;
        User user;
        List<Event> events;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query query = (Query) session.createQuery("FROM User U WHERE U.id = " + id);
            events = session.createQuery("FROM Event").list();
            user = (User)query.uniqueResult();
            user.setEvents(events);
            transaction.commit();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        Transaction transaction;
        List<User> users;
        List<Event> events;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            events = session.createQuery("FROM Event").list();
            for(User user: users){
                user.setEvents(events);
            }
            transaction.commit();
        }
        return users;
    }

    @Override
    public User save(User user) {
        Transaction transaction;
        Long userId;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            userId = (Long) session.save(user);
            user.setId(userId);
            transaction.commit();
        }
        return user;
    }

    @Override
    public User update(User user) {
        Transaction transaction;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
        return getById(user.getId());
    }

    @Override
    public void deleteById(Long id) {
        User userDelete;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            userDelete = session.get(User.class,id);
            session.delete(userDelete);
            transaction.commit();
        }
    }
}
