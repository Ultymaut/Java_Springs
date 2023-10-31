package com.example.demoFirst.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/hello")
public class HelloRestController {


   // @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping
    public String sayHello(){
        System.out.println("hello");
        return "Hello World !!!";
    }

   // @RequestMapping(value = "/personnes")
    @GetMapping(value = "personnes")
    public List<String> personJson(){
        return List.of("John Dupont","Maria Martez","Chloée Smith");
    }

}
