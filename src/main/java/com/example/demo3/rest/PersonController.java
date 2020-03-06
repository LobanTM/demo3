package com.example.demo3.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.Person;
import com.example.demo3.model.Project;
import com.example.demo3.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PersonController.class);
	final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	//get all persons
	@GetMapping("/")
    public Iterable<Person> getPersons() {        
        return personService.getAll();
    }	
	
	//get person by id
	@GetMapping("{id}")
	public Person getOne(@PathVariable("id") long id) {
		return personService.getById(id);
	} 
	
	//add new person
	@PostMapping("/")
	public Person create(@RequestBody String name, String email) {
		Person person = new Person(name, email,String.format("Added at %s", LocalDateTime.now()));
		return personService.save(person);
	}
	//update person by id
	@PutMapping("{id}")
	public Person update(@PathVariable("id") long id,	@RequestBody String name) {
		Person existingPerson = personService.getById(id);
		existingPerson.setName(name);
    	return personService.save(existingPerson);
	}
	//delete person by id
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		Person person = personService.getById(id);
		personService.delete(id);
	}
	/*
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPersons(){
	   List<Person> persons = personService.getAll();
	   if (persons == null){
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	   return new ResponseEntity<>(persons, HttpStatus.OK);
	}
	//create person
	@RequestMapping(value = "/",method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Person> addPerson(@RequestBody String name, String email){
		Person person = new Person(name, email,String.format("Added at %s", LocalDateTime.now()));
		
	   	personService.save(person);
	    return new ResponseEntity<>(person, HttpStatus.CREATED);
	}
	//get person by id	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable("id") long id){
	   Person person = personService.getById(id);
	   if (person == null){
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	   return new ResponseEntity<>(person, HttpStatus.OK);
	}
	//update person by id
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> updatePerson(@PathVariable("id") long id,
											@RequestBody String name, String email){
	   	Person existingPerson = personService.getById(id);
	    if (existingPerson == null){
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    }
	    else {
	    	existingPerson.setName(name);
	    	existingPerson.setEmail(email);
	     	personService.save(existingPerson);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}
	//delete person by id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") long id){
    	Person person = personService.getById(id);
        if (person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
        	personService.delete(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }  
	*/
	
	/*@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable("email") String email){
		Person person = null;		
		if (!personService.findByEmail(email).isEmpty()) {
			 person = personService.findByName(email).get(0);
			 if (person == null){
			       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			   }
		}	  
	   return new ResponseEntity<>(person, HttpStatus.OK);
	}
	*/
	
	
 
    

	 
}
