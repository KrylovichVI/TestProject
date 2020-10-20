package com.krylovichVI.TestProject.service;

import com.krylovichVI.TestProject.domain.Person;
import com.krylovichVI.TestProject.dto.PersonDTO;
import com.krylovichVI.TestProject.mapper.PersonMapper;
import com.krylovichVI.TestProject.repo.PersonRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public PersonDTO getPersonById(Long personId) {
        return PersonMapper.INSTANCE.toDTO(personRepo.findById(personId).get());
    }

    public List<PersonDTO> getAllPerson() {
        return PersonMapper.INSTANCE.toDTO(personRepo.findAll());
    }

    public void deletePerson(Long personId){
        Person personFormDb = personRepo.findById(personId).get();

        personRepo.delete(personFormDb);
    }

    public PersonDTO updatePerson(Long personOld, PersonDTO personNew) {
        PersonDTO personFromDB = PersonMapper.INSTANCE.toDTO(personRepo.findById(personOld).get());
        BeanUtils.copyProperties(personNew, personFromDB, "id");
        Person person = personRepo.save(PersonMapper.INSTANCE.toEntity(personFromDB));

        return PersonMapper.INSTANCE.toDTO(person);
    }

    public PersonDTO createPerson(PersonDTO person) {
        Person personFromDB = personRepo.save(PersonMapper.INSTANCE.toEntity(person));

        return PersonMapper.INSTANCE.toDTO(personFromDB);
    }

    public boolean isPersonByName(String name) {
        if(personRepo.findByName(name).get() != null){
            return true;
        } else {
            return false;
        }
    }

    public PersonDTO updatePersonByName(PersonDTO personDTO) {
        Person personFromDb = personRepo.findByName(personDTO.getName()).get();
        Person entity = PersonMapper.INSTANCE.toEntity(personDTO);
        personFromDb.setContacts(entity.getContacts());
        return PersonMapper.INSTANCE.toDTO(personRepo.save(personFromDb));
    }
}
