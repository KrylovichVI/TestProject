package com.krylovichVI.TestProject.controller;

import com.krylovichVI.TestProject.domain.Person;
import com.krylovichVI.TestProject.dto.PersonDTO;
import com.krylovichVI.TestProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PersonDTO getOnePerson(@PathVariable(name = "id") Person personId){
        return personService.getPersonById(personId.getId());
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO person){
        if(personService.isPersonByName(person.getName())){
            return personService.updatePersonByName(person);
        }else {
            return personService.createPerson(person);
        }
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
