package com.example.exercice3.controller;

import org.springframework.ui.Model;
import com.example.exercice3.model.Student;
import com.example.exercice3.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }
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
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("student", students);
        return "student/listeStudent";
    }
    @GetMapping("/infoStudent/{id}")
    public String infoStudent(Model model, @PathVariable Long id){
        Student student = studentService.getStudentById(id);
        if (student != null){
            model.addAttribute("student", student);
            return "student/infoStudent";
        }else {
            return "home";
        }
    }
    @PostMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, @ModelAttribute Student student){
        studentService.updateStudent(id,student);
        return "student/listeStudent";
    }

    @PostMapping("/delStudent/{id}")
    public String delStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "home";
    }
}
