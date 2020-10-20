package com.krylovichVI.TestProject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = { "id", "telephone"})
public class Contacts{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String telephone;

    @ManyToOne()
    @JoinColumn( name = "id_person")
    private Person person;
}
