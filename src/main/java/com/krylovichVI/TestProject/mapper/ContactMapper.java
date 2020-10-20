package com.krylovichVI.TestProject.mapper;

import com.krylovichVI.TestProject.domain.Contacts;
import com.krylovichVI.TestProject.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "personId", source = "person.id")
    ContactDTO toDTO(Contacts contacts);
    @Mapping(target = "person.id", source = "personId")
    Contacts toEntity(ContactDTO contactDTO);
}
