package com.microservices.employeeappcrudop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeerepository;

    @GetMapping("/getMsg")
    public String getHelloWorld() {
        return "Hello World";
    }

    @PostMapping("/createEmp")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeerepository.save(employee);
    }

    @GetMapping("/findAllEmp")
    public List<Employee> findAllEmployees() {

       // return employeerepository.findAll();
        List<Integer> employeeIdsList=CacheManager.cache.keySet().stream().collect(Collectors.toList());

        return CacheManager.cache.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/findEmpById/{empId}")
    public String findEmpById(@PathVariable int empId) {
       // Optional<Employee> employee = employeerepository.findById(empId);
        Employee employee=CacheManager.cache.get(empId);
        if (employee != null) {
            return employee.toString();
        } else {
            return "No Employee found for given empId";
        }
    }

    @PutMapping("/updateEmployee/{empId}")
    public String updateEmployee(@PathVariable int empId,@RequestBody Employee employee) {
        Optional<Employee> employee1 = employeerepository.findById(empId);
        if (employee1.isPresent()) {
            return employeerepository.save(employee).toString();
        } else {
            return "Employee is not present by given Id";
        }
    }

    @DeleteMapping("/deleteById/{empId}")
    public  String deleteEmployee(@PathVariable int empId)
    {
     Optional<Employee> employee =employeerepository.findById(empId);
     if (employee.isPresent())
     {
         employeerepository.deleteById(empId);
         return  "Employee delete successfully";
     }
     else {
          return "unable to delete since employee is not present for given empId";
     }
    }
}


