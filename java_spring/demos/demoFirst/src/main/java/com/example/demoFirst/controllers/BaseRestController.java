package com.example.demoFirst.controllers;


import com.example.demoFirst.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {


    // Injection de dépendance par constructeur
    private final GreetingService greetingService;

    private final GreetingService greetingService2;

    @Autowired
    public BaseRestController(@Qualifier("salutations") GreetingService greetingService,@Qualifier("greetings") GreetingService greetingService2){
        this.greetingService = greetingService;
        this.greetingService2 = greetingService2;
    }

    @RequestMapping(value = "/hello-service")
    public String sayHello(){
        System.out.println(greetingService.sayHello());
        return "coucou";
    }

    @RequestMapping(value = "/hello-service2")
    public String sayHello2(){
        System.out.println(greetingService2.sayHello());
        return "hello";
    }
}
