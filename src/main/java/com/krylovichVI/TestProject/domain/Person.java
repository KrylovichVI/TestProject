package com.krylovichVI.TestProject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany( mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Contacts> contacts;

}
