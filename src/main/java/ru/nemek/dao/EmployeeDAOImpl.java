package  ru.nemek.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nemek.entities.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void add(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
    }

    @Override
    public List getAll() {
        System.out.println("Тут");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee").list();
    }
}
