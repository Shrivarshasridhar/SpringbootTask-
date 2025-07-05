package com.example.Student.controllers;

import com.example.Student.models.Students;
import com.example.Student.Service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s")
public class HelloWorldcontroller {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public List<Students> getMethod(){

        return hws.getMethod();

    }
    @GetMapping("/{stuId}")
    public Students getMethodById(@PathVariable int stuId){
        return hws.getMethodById(stuId);
    }
    @PutMapping("/{stuId}")
    public String putMethod(@PathVariable int stuId, @RequestBody Students student){
        return  hws.putMethod(stuId,student);
    }
    @PostMapping("/")
    public String postMethod(@RequestBody Students student){
        return hws.postMethod(student);
    }
    @DeleteMapping("/{stuId}")
    public String deleteMapping(@PathVariable int stuId){
        return hws.deleteMethod(stuId);
    }
}
