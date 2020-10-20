package com.krylovichVI.TestProject.repo;

import com.krylovichVI.TestProject.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepo extends JpaRepository<Contacts, Long> {
}
