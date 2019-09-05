package ru.nemek.validates;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.nemek.entities.Employee;

public class EmployeeValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Employee employee = (Employee) target;

        System.out.println(employee);

    }
}
