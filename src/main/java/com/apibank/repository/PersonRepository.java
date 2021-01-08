package com.apibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibank.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	 

}
