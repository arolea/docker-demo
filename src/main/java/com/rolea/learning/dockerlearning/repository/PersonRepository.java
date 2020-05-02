package com.rolea.learning.dockerlearning.repository;

import com.rolea.learning.dockerlearning.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);

}
