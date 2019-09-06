package ru.nemek.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nemek.entities.Phone;

import java.util.List;
@Repository
public class PhoneDAOImpl implements PhoneDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Phone getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Phone.class, id);
    }

    @Override
    public void add(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.save(phone);
    }

    @Override
    public void update(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.update(phone);
    }

    @Override
    public void delete(Phone phone) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(phone);
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Phone").list();
    }
}
