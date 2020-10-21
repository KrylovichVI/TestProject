package com.krylovichVI.TestProject.controller;

import com.krylovichVI.TestProject.dto.ContactDTO;
import com.krylovichVI.TestProject.service.ContactsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactsService contactsService;

    public ContactController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping()
    public ContactDTO create(){
        return null;
    }
}
