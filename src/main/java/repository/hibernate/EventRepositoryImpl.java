package repository.hibernate;

import model.Event;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.EventRepository;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    @Override
    public Event getById(Long id) {
        Transaction transaction;
        Event event;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query query = (Query) session.createQuery("FROM Event U JOIN FETCH U.file WHERE U.id = " + id);
            event = (Event) query.uniqueResult();
            transaction.commit();
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        Transaction transaction;
        List<Event> events;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            events = session.createQuery("FROM Event U JOIN FETCH U.file").list();
            transaction.commit();
        }
        return events;
    }

    @Override
    public Event save(Event event) {
        Transaction transaction;
        Long eventId;
        Long fileId;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            eventId = (Long) session.save(event);
            fileId = (Long) session.save(event.getFile());
            event.setId(eventId);
            event.getFile().setId(fileId);
            transaction.commit();
        }
        return event;
    }

    @Override
    public Event update(Event event) {
        Transaction transaction;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(event);
            transaction.commit();
        }
        return getById(event.getId());
    }

    @Override
    public void deleteById(Long id) {
        Event eventDelete;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            eventDelete = session.get(Event.class, id);
            session.delete(eventDelete);
            transaction.commit();
        }
    }
}
