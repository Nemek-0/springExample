package  ru.nemek.dao;


import ru.nemek.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getById(int id);
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    List getAll();
}
