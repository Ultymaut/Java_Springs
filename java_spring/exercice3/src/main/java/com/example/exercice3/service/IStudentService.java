package com.example.exercice3.service;

import com.example.exercice3.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id,Student updateStudent);

    void deleteStudent(Long id);
}
