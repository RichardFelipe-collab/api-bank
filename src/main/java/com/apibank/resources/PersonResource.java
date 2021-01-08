package com.apibank.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apibank.entities.Person;
import com.apibank.service.PersonService;
import com.apibank.service.exceptions.DataIntegrityException;


@RestController
@RequestMapping(value = "/persons")
public class PersonResource { 
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>  > findAll(){
		
		List<Person> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping
	public ResponseEntity<Person> insert(@Valid @RequestBody Person obj, BindingResult br){
		if(br.hasErrors()) {
			throw new DataIntegrityException(br.toString());
		}
		obj = service.insert( obj);
		
		URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}

}
