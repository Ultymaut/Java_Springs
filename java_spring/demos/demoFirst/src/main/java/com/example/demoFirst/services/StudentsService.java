package com.example.demoFirst.services;

import com.example.demoFirst.models.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentsService {
    private List<Students> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Students( "Doe", "John", 25));
        students.add(new Students("Smith", "Alice", 22));
        students.add(new Students("Coco", "Gota", 31));
    }
    public List<Students> getAllStudents(){
        return students;
    }


    public Students getStudentById(int id) {
        for (Students student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
