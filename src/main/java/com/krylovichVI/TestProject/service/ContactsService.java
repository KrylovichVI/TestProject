package com.krylovichVI.TestProject.service;

import com.krylovichVI.TestProject.dto.PersonDTO;
import com.krylovichVI.TestProject.repo.ContactsRepo;
import org.springframework.stereotype.Service;

@Service
public class ContactsService {
    private final ContactsRepo contactsRepo;

    public ContactsService(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

}
