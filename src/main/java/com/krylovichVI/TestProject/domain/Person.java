package com.krylovichVI.TestProject.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set;


/**
 * Person class of entity
 * @author Krylovich Vitaly
 * @version 1.0
 * */
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

    @OneToMany( mappedBy = "person", orphanRemoval = true)
    private Set<Contacts> contacts;

}
