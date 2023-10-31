package com.example.demoFirst.controllers;

import com.example.demoFirst.models.Students;
import com.example.demoFirst.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentsCrudController {

        private StudentsService studentsService;

        @Autowired
        public void StudentController(StudentsService studentsService) {
            this.studentsService = studentsService;
        }

        @GetMapping // GET http://localhost:8081/api/students
        public List<Students> getAllStudents() {
            return studentsService.getAllStudents();
        }

        @GetMapping ("/{id}") //GET http://localhost:8081/api/students
        public Students getStudentById(@PathVariable int id){
            return studentsService.getStudentById(id);
        }

        @PostMapping //POST http://localhost:8081/api/students
        public Students create(@RequestBody Students students){
            return  students;
        }

        @DeleteMapping("/{id}") //Delete http://localhost:8081/api/students
        public String delete(@PathVariable int id){
            return  "La personne que vous voulez supprimer est : " + id;
        }

        @PutMapping("/{id}") //Put http://localhost:8081/api/students
        public String updatePerson(@PathVariable int id){
            return  "La personne que vous voulez modifier est : " + id;
        }
}
