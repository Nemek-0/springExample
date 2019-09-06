package ru.nemek.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nemek.entities.Position;

import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Position getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Position.class, id);
    }

    @Override
    public void add(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.save(position);
    }

    @Override
    public void update(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.update(position);
    }

    @Override
    public void delete(Position position) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(position);
    }

    @Override
    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Position").list();
    }
}
