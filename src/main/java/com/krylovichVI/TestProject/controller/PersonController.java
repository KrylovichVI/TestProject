package com.krylovichVI.TestProject.controller;

import com.krylovichVI.TestProject.dto.PersonDTO;
import com.krylovichVI.TestProject.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDTO> list(){
        return personService.getAllPerson();
    }

    @GetMapping("{id}")
    public PersonDTO getOnePerson(@PathVariable(name = "id") Long personId){
        return personService.getPersonById(personId);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO person){
        return personService.createPerson(person);
    }

    @PutMapping("{id}")
    public PersonDTO updatePerson(@PathVariable("id") Long personOld, @RequestBody PersonDTO personNew){
        return personService.updatePerson(personOld, personNew);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") Long personId){
        personService.deletePerson(personId);
    }
}
