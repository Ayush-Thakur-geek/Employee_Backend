package com.example.demo.Service;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null ||
        employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());

        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
//    public Employee getEmployeeById(String id) {
//        for (int i = 0; i < employees.size(); i++) {
//            if (id.equals(employees.get(i).getEmployeeId())) {
//                return employees.get(i);
//            }
//        }
//        return null;
//    }
    public Employee getEmployeeById(String id) {
        return employees.
                stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee of Id: " + id + ", not found!"));
    }

    @Override
    public String deleteEmployeeById(String id) {
//        Employee employee = employees
//                .stream()
//                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
//                .findFirst()
//                .get();
        employees.remove(getEmployeeById(id));
        return "Employee deleted with id: " + id;
    }
}
