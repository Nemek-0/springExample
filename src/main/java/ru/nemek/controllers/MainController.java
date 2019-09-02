package  ru.nemek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.nemek.entities.Employee;
import ru.nemek.service.EmployeeService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        Employee employee = employeeService.getById(1);
        List<Employee> employees = employeeService.getAll();
        System.out.println(employees);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
