package  ru.nemek.service;



import ru.nemek.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(int id);
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    List getAll();
}
