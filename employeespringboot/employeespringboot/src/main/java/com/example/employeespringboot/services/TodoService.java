package com.example.employeespringboot.services;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.models.Todo;
import com.example.employeespringboot.repository.RegisterDetailsRepository;
import com.example.employeespringboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private RegisterDetailsRepository registerRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Todo assignTaskToEmployee(int empId, Todo todo) {
        RegisterDetails user = registerRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        boolean hasRequiredRole = user.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equalsIgnoreCase("DEVELOPER")); // customize as needed

        if (!hasRequiredRole) {
            throw new RuntimeException("Task can only be assigned to DEVELOPERs");
        }

        todo.setEmployee(user);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByEmployee(int empId) {
        return todoRepository.findByEmployeeEmpId(empId);
    }
}