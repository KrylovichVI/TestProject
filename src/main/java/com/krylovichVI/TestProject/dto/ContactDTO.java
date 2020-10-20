package com.krylovichVI.TestProject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString
public class ContactDTO {
    private Long id;
    private String telephone;
    private Long personId;
}
