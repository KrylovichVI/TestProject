package com.krylovichVI.TestProject.mapper;

import com.krylovichVI.TestProject.domain.Person;
import com.krylovichVI.TestProject.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDTO(Person person);
    List<PersonDTO> toDTO(List<Person> personList);
    Person toEntity(PersonDTO personDTO);
}
