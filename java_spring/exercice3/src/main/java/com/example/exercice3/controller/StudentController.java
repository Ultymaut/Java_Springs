package com.example.exercice3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.example.exercice3.model.Student;
import com.example.exercice3.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;
//    @Autowired
//    public StudentController(IStudentService studentService){
//        this.studentService = studentService;
//    }
    @GetMapping
    public String homePage(){
        return "home";
    }
    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "/student/addStudent";
    }
    @PostMapping("/addStudent")
    public String addStudent(Student student){
        studentService.createStudent(student);
        return "redirect:listeStudent";
    }
    @GetMapping("/listeStudent")
    public String listeStudent(Model model){
        model.addAttribute("student", studentService.getAllStudents());
        return "student/listeStudent";
    }
    @GetMapping("/infoStudent/{id}")
    public String infoStudent(Model model, @PathVariable Long id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/infoStudent";
    }
    @PostMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute Student student){
        studentService.updateStudent(id,student);
        return "home";
    }

    @GetMapping("/delStudent/{id}")
    public String delStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "home";
    }
}
