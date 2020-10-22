package com.krylovichVI.TestProject.service;

import com.krylovichVI.TestProject.domain.Contacts;
import com.krylovichVI.TestProject.domain.Person;
import com.krylovichVI.TestProject.dto.ContactDTO;
import com.krylovichVI.TestProject.dto.PersonDTO;
import com.krylovichVI.TestProject.mapper.ContactMapper;
import com.krylovichVI.TestProject.mapper.PersonMapper;
import com.krylovichVI.TestProject.repo.ContactsRepo;
import org.springframework.stereotype.Service;

@Service
public class ContactsService {
    private final ContactsRepo contactsRepo;
    private final PersonService personService;

    public ContactsService(ContactsRepo contactsRepo, PersonService personService) {
        this.contactsRepo = contactsRepo;
        this.personService = personService;
    }

    /**Get a dto object and convert to entity and
     * save entity of database.
     * @param contactDTO - dto object of contact
     * @return dto object
     */
    public ContactDTO createContact(ContactDTO contactDTO){
        PersonDTO personById = personService.getPersonById(contactDTO.getPersonId());
        Person personFromDb = PersonMapper.INSTANCE.toEntity(personById);
        Contacts contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contact.setPerson(personFromDb);
        Contacts contactFromDb = contactsRepo.save(contact);
        return ContactMapper.INSTANCE.toDTO(contactFromDb);
    }

    /**Delete contact by id
     * @param contactId - id of contact
     */
    public void deleteContact(Long contactId) {
        contactsRepo.deleteById(contactId);
    }
}
