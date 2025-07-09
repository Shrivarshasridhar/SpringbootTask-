package com.example.Student.Service;

import com.example.Student.models.Students;
import com.example.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    @Autowired
    StudentRepository stud;
//    List<Students> stu=new ArrayList<>(
//            Arrays.asList(
//                    new Students(1,"varsha","a"),
//                    new Students(2,"kirthi","b"),
//                    new Students(3,"maha","c"),
//                    new Students(4,"jack","d"),
//                    new Students(5,"harsh","e"),
//                    new Students(6,"malik","f")
//
//            )
//    );
    public List<Students> getMethod(){
        return stud.findAll();
    }
    public Students getMethodById(int id){

        return stud.findById(id).orElse(new Students());
    }
    public String putMethod(int stuId,Students student){
        stud.save(student);
        return "Student updated successfully";
    }
    public String postMethod(int stuId,Students student ){
        stud.save(student);
        return "Students added successfully";

    }
    public String deleteMethod(int id) {
        stud.deleteById(id);
        return "Student deleted successfully";
    }
    public String deleteall() {
        stud.deleteAll();
        return "All students deleted successfully";
    }

    public List<Students> getMethodByName(String name) {

        return stud.findByName(name);
    }
}
