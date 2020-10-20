package com.krylovichVI.TestProject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString
public class PersonDTO {
    private Long id;
    private String name;
    private Set<ContactDTO> contacts;
}
