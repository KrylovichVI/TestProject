package com.krylovichVI.TestProject.controller;

import com.krylovichVI.TestProject.service.PersonService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    private String main(Model model){
        model.addAttribute("persons", personService.getAllPerson());
        return "index";
    }
}
