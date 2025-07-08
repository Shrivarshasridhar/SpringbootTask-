package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.Employee;
import com.example.employeespringboot.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public String routes(){
        return "welcome to spring boot security";
    }
    @GetMapping("/e")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }
    @GetMapping("/e/role/{role}")
    public List<Employee> getMethodByRole(@PathVariable String role){
        return hws.getMethodByRole(role);
    }

    @GetMapping("/e/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }

    @PutMapping("/e")
    public String putMethod( @RequestBody Employee employee){
        return  hws.updateEmployee(employee);
    }

    @PostMapping("/e")
    public String addEmployee(@RequestBody Employee employee){

         hws.addEmployee(employee);
         return "Employee added successfully!!!";
    }

    @DeleteMapping("/e/{empId}")
    public String deleteMethodById(@PathVariable int empId){
         hws.deleteMethodById(empId);
         return "deleted";
    }
    @DeleteMapping("/e")
    public String deleteMethod(){
        hws.deleteMethod();
        return "deleted";
    }
}
