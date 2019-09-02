package  ru.nemek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nemek.entities.Employee;
import ru.nemek.service.EmployeeService;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        List<Employee> employees = employeeService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id){
        Employee employee = employeeService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEmployee");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(employee);
        employeeService.update(employee);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @InitBinder("employee")
    public void customizeBinding (WebDataBinder binder, Object sss) {
        System.out.println(sss.getClass());
        Employee employee = (Employee) binder.getTarget();
        employee.setBirthday(LocalDate.parse("1997-05-25"));
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        //binder.registerCustomEditor(LocalDate.class, "birthDay",
                //LocalDate.parse("1997-05-25"));
    }

    /*class AuthorEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text){
            System.out.println("111");
            Employee employee = new Employee();
            employee.setBirthday(LocalDate.parse(text));
            setValue(employee);
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Employee.class, "birthDay", new AuthorEditor());
    }*/
}
