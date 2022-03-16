package com.shramko.spring.rest;

import com.shramko.spring.rest.configuration.MyConfig;
import com.shramko.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employeeById = communication.getEmployee(2);
        System.out.println(employeeById);

        Employee employee = new Employee("Sveta", "Sokolova", "HR", 800);
        employee.setId(9);
        communication.saveEmployee(employee);

        communication.deleteEmployee(employee.getId());
    }
}
