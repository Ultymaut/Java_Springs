package com.example.demoFirst.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/base")
@RequestMapping("/base") // http://localhost:8080/base
public class BaseController {


   // @RequestMapping(value = "1-param",method = RequestMethod.GET)
    @GetMapping("1-param") // GET http://localhost:8080/base/1-param
    public String getOneParam(Model model){
        model.addAttribute("paramA","John Dupont");
        return "1-param";
    }

    @GetMapping("2-params") // GET http://localhost:8080/base/2-params
    public String getTwoParam(Model model){
        model.addAttribute("paramA","John Dupont");
        model.addAttribute("paramB","Maria Smith");
        return "2-param";
    }

    @GetMapping("coll-params") // GET http://localhost:8080/base/coll-params
    public String getCollParams(Model model){
       model.addAttribute("params",new ArrayList<String>());
       // model.addAttribute("params", List.of("John Dupont","Maria Smith","Toto Tata"));
        return "dossier/coll-params";
    }


}
