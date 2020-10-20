package com.krylovichVI.TestProject.repo;

import com.krylovichVI.TestProject.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long personId);
    Optional<Person> findByName(String name);
}
