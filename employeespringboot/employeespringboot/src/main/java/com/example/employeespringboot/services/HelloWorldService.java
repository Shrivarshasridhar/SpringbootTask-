package com.example.employeespringboot.services;

import com.example.employeespringboot.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp=new ArrayList<>(
            Arrays.asList(
                    new Employee(1,"varsha","hr"),
                    new Employee(2,"kirthi","manager"),
                    new Employee(3,"maha","ceo"),
                    new Employee(4,"jack","hr"),
                    new Employee(5,"harsh","manager"),
                    new Employee(6,"malik","ceo")

            )
    );
    public List<Employee> getMethod(){
        return emp;
    }
    public Employee getMethodById(int id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(id==emp.get(i).getEmpId()){
                System.out.println("Employee"+emp.get(i).getEmpId()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            return emp.get(ind);
        }
        else{
            return new Employee();
        }
    }
    public String putMethod(int id,Employee employee){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(id==emp.get(i).getEmpId()){
                System.out.println("Employee"+emp.get(i).getEmpId()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            emp.set(ind,employee);
            return "Employee updated";
        }
        else{
            return "Employee  not updated";
        }
    }
    public String postMethod(Employee employee){
        emp.add(employee);
        return "employee added successfully";

    }
    public String deleteMethod(int id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<emp.size();i++){
            if(id==emp.get(i).getEmpId()){
                System.out.println("Employee"+emp.get(i).getEmpId()+emp.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
             emp.remove(ind);
             return "employee deleted";
        }
        else{
            return "employee not deleted";
        }
    }
}
