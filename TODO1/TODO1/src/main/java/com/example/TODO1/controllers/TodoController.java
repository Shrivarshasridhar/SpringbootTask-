package com.example.TODO1.controllers;

import com.example.TODO1.models.Todo;
import com.example.TODO1.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/t")
public class TodoController {
    @Autowired
    TodoService tds;
    @GetMapping
    public List<Todo> getMethod(){
        return tds.getMethod();
    }
    @GetMapping("/{tasId}")
    public Todo getMethodById(@PathVariable int tasId){
        return tds.getMethodById(tasId);
    }
    @PostMapping
    public String postMethod(@RequestBody Todo tas){
        return tds.postMethod(tas);
    }
    @PutMapping("/{tasId}")
    public String putMethod(@PathVariable int tasId,@RequestBody Todo tas){
        return tds.putMethod(tasId,tas);
    }
    @DeleteMapping("/{tasId}")
    public String deleteMethod(@PathVariable int tasId){
        return tds.deleteMethod(tasId);
    }

}

