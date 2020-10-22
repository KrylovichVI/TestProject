package com.krylovichVI.TestProject.controller;

import com.krylovichVI.TestProject.dto.ContactDTO;
import com.krylovichVI.TestProject.service.ContactsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class ContactsController {
    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping()
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO){
        return contactsService.createContact(contactDTO);
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable("id") Long contactId){
        contactsService.deleteContact(contactId);
    }

}
