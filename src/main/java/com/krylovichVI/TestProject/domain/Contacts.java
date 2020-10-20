package com.krylovichVI.TestProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


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
