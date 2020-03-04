package com.example.demo3.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.Person;
import com.example.demo3.service.PersonService;

@RestController
@RequestMapping("/api")
public class ApiController {

    //final PersonRepository personRepository;
    final PersonService personService;

    //public ApiController(PersonRepository personRepository) {
    //    this.personRepository = personRepository;
    //}

    public ApiController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/persons")
    public Iterable<Person> getPersons() {
        //return personRepository.findAll();
        return personService.getAll();
    }
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Person> getPerson(@PathVariable("id") long id){
		   Person person = personService.getById(id);
	        if (person == null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(person, HttpStatus.OK);
	    }
}

