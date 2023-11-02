package com.example.demoFirst.controllers;

import com.example.demoFirst.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/crud")
public class CRUDController {

    @GetMapping//GET http://localhost:8081/api/v1/crud
    public List <String> getAllPerson(){
        return List.of("John", "Maria","Chloée");
    }

    @GetMapping ("/{id}") //GET http://localhost:8081/api/v1/crud
    public String getOnePerson(@PathVariable int id){
        return  "vous chercher la personne avec l'id" + id;
    }

    @PostMapping //POST http://localhost:8081/api/v1/crud
    public Person create(@RequestBody Person person){
        return  person;
    }

    @DeleteMapping("/{id}") //Delete http://localhost:8081/api/v1/crud
    public String delete(@PathVariable int id){
        return  "La personne que vous voulez supprimer est : " + id;
    }

    @PutMapping("/{id}") //Put http://localhost:8081/api/vi/crud
    public String updatePerson(@PathVariable int id){
        return  "La personne que vous voulez modifier est : " + id;
    }
}


