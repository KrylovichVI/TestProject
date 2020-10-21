package com.krylovichVI.TestProject.repo;

import com.krylovichVI.TestProject.domain.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    @EntityGraph(attributePaths = {"contacts"})
    List<Person> findAll();
    Optional<Person> findById(Long personId);
    Optional<Person> findByName(String name);
}
