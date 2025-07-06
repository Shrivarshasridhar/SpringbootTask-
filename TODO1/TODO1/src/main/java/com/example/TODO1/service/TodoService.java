package com.example.TODO1.service;

import com.example.TODO1.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class TodoService {


    List<Todo> td = new ArrayList<>(
            Arrays.asList(
                    new Todo(1, "homework", "varsha", "yet to start"),
                    new Todo(2, "wash", "mani", "inprogress"),
                    new Todo(3, "project", "kirthi", "completed"),
                    new Todo(4, "clean", "nithya", "completed")
            )
    );

    public List<Todo> getMethod() {
        return td;
    }

    public Todo getMethodById(int id) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < td.size(); i++) {
            if (id == td.get(i).getTasId()) {
                System.out.println("Task" + td.get(i).getTasId() + td.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return td.get(ind);
        } else {
            return new Todo();
        }
    }

    public String postMethod(Todo tas) {
        td.add(tas);
        return "task added successfully";
    }

    public String putMethod(int id, Todo tas) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < td.size(); i++) {
            if (id == td.get(i).getTasId()) {
                System.out.println("Task" + td.get(i).getTasId() + td.get(i));
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            td.set(ind, tas);
            return "task updated successfully";
        } else {
            return "task not updated ";
        }
    }

    public String deleteMethod(int id) {
        int ind = 0;
        boolean flag = false;
        for (int i = 0; i < td.size(); i++) {
            if (id == td.get(i).getTasId()) {
                ind = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            td.remove(ind);
            return "task deleted successfully";
        } else {
            return "task not deleted ";
        }
    }
}

