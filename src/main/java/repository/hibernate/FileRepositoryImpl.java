package repository.hibernate;

import model.File;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.FileRepository;
import java.util.List;

public class FileRepositoryImpl implements FileRepository {
    @Override
    public File getById(Long id) {
        Transaction transaction;
        File file;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            file = session.get(File.class, id);
            transaction.commit();
        }
        return file;
    }

    @Override
    public List<File> getAll() {
        Transaction transaction;
        List<File> files;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            files = session.createQuery("FROM File ").list();
            transaction.commit();
        }
        return files;
    }

    @Override
    public File save(File file) {
        Transaction transaction;
        Long fileId;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            fileId = (Long) session.save(file);
            file.setId(fileId);
            transaction.commit();
        }
        return file;
    }

    @Override
    public File update(File file) {
        Transaction transaction;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(file);
            transaction.commit();
        }
        return getById(file.getId());
    }

    @Override
    public void deleteById(Long id) {
        File fileDelete;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            fileDelete = session.get(File.class, id);
            session.delete(fileDelete);
            transaction.commit();
        }
    }
}
