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

    /**
     * @param personId - id of
     * @return dto person from id
     */
    public PersonDTO getPersonById(Long personId) {
        return PersonMapper.INSTANCE.toDTO(personRepo.findById(personId).get());
    }

    /**
     * @return List of all personDto
     */
    public List<PersonDTO> getAllPerson() {
        return PersonMapper.INSTANCE.toDTO(personRepo.findAll());
    }

    /**
     * Delete person by  person id
     * @param personId - id in person entity
     */
    public void deletePerson(Long personId){
        Person personFormDb = personRepo.findById(personId).get();

        personRepo.delete(personFormDb);
    }


    /**
     * Update old person to new except of id
     * @param personOld - id in current person
     * @param personNew - dto object of  new person
     */
    public PersonDTO updatePerson(Long personOld, PersonDTO personNew) {
        PersonDTO personFromDB = PersonMapper.INSTANCE.toDTO(personRepo.findById(personOld).get());
        BeanUtils.copyProperties(personNew, personFromDB, "id");
        Person person = personRepo.save(PersonMapper.INSTANCE.toEntity(personFromDB));

        return PersonMapper.INSTANCE.toDTO(person);
    }

    /**
     * Create new Person of database
     * @param person - dto object of  new person
     */
    public PersonDTO createPerson(PersonDTO person) {
        Person personFromDB = personRepo.save(PersonMapper.INSTANCE.toEntity(person));

        return PersonMapper.INSTANCE.toDTO(personFromDB);
    }
}
