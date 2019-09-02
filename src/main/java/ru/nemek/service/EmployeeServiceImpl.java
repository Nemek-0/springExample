package  ru.nemek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nemek.dao.EmployeeDAO;
import ru.nemek.entities.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Transactional
    @Override
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    @Transactional
    @Override
    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    @Transactional
    @Override
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }

    @Transactional
    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        for(Object employee : employeeDAO.getAll())
            list.add((Employee) employee);
        return list;
    }
}
