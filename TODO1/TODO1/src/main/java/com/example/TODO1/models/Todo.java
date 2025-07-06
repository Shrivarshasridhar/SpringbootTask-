package com.example.TODO1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo {
    private int tasId;
    private String Task;
    private String name;
    private String status;
}
