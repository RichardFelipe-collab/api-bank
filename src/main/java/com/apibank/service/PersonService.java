package com.apibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.apibank.entities.Person;
import com.apibank.repository.PersonRepository;
import com.apibank.service.exceptions.DataIntegrityException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;  
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person insert(Person obj) {
		obj.setId(null);
		try {
		return repository.save(obj);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) não foi(foram) preenchido(s) e ou foram inseridos dados existentes CPF e EMAIL");
		}
	}
}
