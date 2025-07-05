package com.example.Student.Service;

import com.example.Student.models.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Students> stu=new ArrayList<>(
            Arrays.asList(
                    new Students(1,"varsha","a"),
                    new Students(2,"kirthi","b"),
                    new Students(3,"maha","c"),
                    new Students(4,"jack","d"),
                    new Students(5,"harsh","e"),
                    new Students(6,"malik","f")

            )
    );
    public List<Students> getMethod(){
        return stu;
    }
    public Students getMethodById(int id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){
            if(id==stu.get(i).getStuId()){
                System.out.println("Student"+stu.get(i).getStuId()+stu.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            return stu.get(ind);
        }
        else{
            return new Students();
        }
    }
    public String putMethod(int id,Students student){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){
            if(id==stu.get(i).getStuId()){
                System.out.println("Student"+stu.get(i).getStuId()+stu.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            stu.set(ind,student);
            return "Students updated";
        }
        else{
            return "Students  not updated";
        }
    }
    public String postMethod(Students student ){
        stu.add(student);
        return "Students added successfully";

    }
    public String deleteMethod(int id){
        int ind=0;
        boolean flag=false;
        for(int i=0;i<stu.size();i++){
            if(id==stu.get(i).getStuId()){
                System.out.println("Students"+stu.get(i).getStuId()+stu.get(i));
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            stu.remove(ind);
            return "Students deleted";
        }
        else{
            return "Students not deleted";
        }
    }
}
