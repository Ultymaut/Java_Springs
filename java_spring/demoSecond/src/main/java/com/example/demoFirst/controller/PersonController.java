package com.example.demoFirst.controller;


import com.example.demoFirst.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {


    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/second")
    public String secondPage(Model model){
        Person person = new Person();
        person.setName("Mohamed");
        model.addAttribute("personSubmit",person);
        return "pageB";
    }

    @PostMapping("/submitForm")
    public String submitFormulaire(@ModelAttribute("personSubmit")Person person){
        System.out.println(person);
        System.out.println(person.getName());
        return "redirect:/";
    }

    @GetMapping("/person")
    public String showOnePerson(@RequestParam("personName") String name,Model model){
        model.addAttribute("myName",name);
        return "/person/person";
    }

}
