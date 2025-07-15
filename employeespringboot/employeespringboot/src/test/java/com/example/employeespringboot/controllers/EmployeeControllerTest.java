package com.example.employeespringboot.controllers;

import com.example.employeespringboot.models.RegisterDetails;
import com.example.employeespringboot.models.UserDetailsDto;
import com.example.employeespringboot.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach

    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRoute() {
        String result = employeeController.route();
        assertEquals("Welcome to SpringBoot Security", result);
    }

    @Test
    void testGetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));
        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        RegisterDetails emp = new RegisterDetails();
        when(employeeService.getEmployeeById(1)).thenReturn(emp);
        RegisterDetails result = employeeController.getEmployeeById(1);
        assertEquals(emp, result);
    }

    @Test
    void testPostMethod() {
        UserDetailsDto employee = new UserDetailsDto();
        when(employeeService.addNewEmployee(employee)).thenReturn("Employee added successfully");
        String result = employeeController.postMethod(employee);
        assertEquals("Employee added successfully", result);
    }

    @Test
    void testPutMethod() {
        when(employeeService.updateEmployee(1)).thenReturn("Employee updated");
        String result = employeeController.putMethod(1);
        assertEquals("Employee updated", result);
    }

    @Test
    void testDeleteMethod() {
        when(employeeService.deleteEmployeeById(1)).thenReturn("Employee deleted");
        String result = employeeController.deleteMethod(1);
        assertEquals("Employee deleted", result);
    }
}
