package com.example.Student.controllers;

import com.example.Student.models.Students;
import com.example.Student.Service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping("/s")
public class HelloWorldcontroller {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/")
    public String routes(){
        return "welcome to student page";
    }
    @GetMapping("/s")
    public List<Students> getMethod(){

        return hws.getMethod();

    }
    @GetMapping("/s/{stuId}")
    public Students getMethodById(@PathVariable int stuId){
        return hws.getMethodById(stuId);
    }
    @GetMapping("/s/{name}")
    public List<Students> getMethodByName(@PathVariable String name){
        return hws.getMethodByName(name);
    }
    @PutMapping("/s/{stuId}")
    public String putMethod(@PathVariable int stuId, @RequestBody Students student){
        return  hws.putMethod(stuId,student);
    }
    @PostMapping("/")
    public String postMethod(@PathVariable int stuId,@RequestBody Students student){
        return hws.postMethod(stuId,student);
    }
    @DeleteMapping("/{stuId}")
    public String deleteMapping(@PathVariable int stuId){
        return hws.deleteMethod(stuId);
    }
    @DeleteMapping("/s")
    public String deleteall(){
        return hws.deleteall();
    }
}
