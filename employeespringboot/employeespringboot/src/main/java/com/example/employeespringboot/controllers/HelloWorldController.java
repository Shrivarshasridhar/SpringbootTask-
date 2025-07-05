package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.Employee;
import com.example.employeespringboot.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e")
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public List<Employee> getMethod(){

        return hws.getMethod();

    }
    @GetMapping("/{empId}")
    public Employee getMethodById(@PathVariable int empId){
        return hws.getMethodById(empId);
    }
    @PutMapping("/{empId}")
    public String putMethod(@PathVariable int empId, @RequestBody Employee employee){
        return  hws.putMethod(empId,employee);
    }
    @PostMapping("/")
    public String postMethod(@RequestBody Employee employee){
        return hws.postMethod(employee);
    }
    @DeleteMapping("/{empId}")
    public String deleteMapping(@PathVariable int empId){
        return hws.deleteMethod(empId);
    }
}
