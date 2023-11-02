package com.example.demoFirst.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("salutations")
//@Primary
public class GreetingsServiceFrench implements GreetingService{
    @Override
    public String sayHello() {
        return "Bonjour tout le monde!";
    }
}
