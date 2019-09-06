package  ru.nemek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nemek.editor.LocalDateEditor;
import ru.nemek.editor.PositionEditor;
import ru.nemek.entities.Employee;
import ru.nemek.entities.Phone;
import ru.nemek.entities.Position;
import ru.nemek.service.EmployeeService;
import ru.nemek.service.PhoneService;
import ru.nemek.service.PositionService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private PhoneService phoneService;

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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEmployee");
        modelAndView.addObject("employee", employeeService.getById(id));
        modelAndView.addObject("positions", positionService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.update(employee);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addEmployee");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("positions", positionService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPage(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.add(employee);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        employeeService.delete(employeeService.getById(id));
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{idEmployee}/phone/{idPhone}", method = RequestMethod.GET)
    public ModelAndView editPhonePage(@PathVariable("idPhone") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPhone");
        modelAndView.addObject("phone",phoneService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit/phone", method = RequestMethod.POST)
    public ModelAndView updatePhone(@ModelAttribute("phone") Phone phone){
        ModelAndView modelAndView = new ModelAndView();
        phoneService.update(phone);
        modelAndView.setViewName("redirect:/edit/"+ phone.getEmployee().getId());
        return modelAndView;
    }

    @InitBinder("employee")
    public void localDataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, "birthday", new LocalDateEditor());
        binder.registerCustomEditor(Position.class, "position", new PositionEditor());
    }

    /*@InitBinder("position")
    public void positionBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, "birthday", new LocalDateEditor());
    }*/


}
