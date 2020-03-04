package com.example.demo3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo3.model.Person;
import com.example.demo3.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PersonServiceImpl.class);
	final PersonRepository personRepository;
		
	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Person save(Person person) {		
		return personRepository.save(person);
	}

	@Override
	public Person getById(long id) {	
		if(personRepository.findById(id)!=null)
			return personRepository.findById(id).get();
		else return null;
	}

	@Override
	public List<Person> getAll() {	
		List<Person> list = new ArrayList<>();
		personRepository.findAll().forEach(l->list.add(l));
		return list;
	}

	@Override
	public void delete(long id) {
		personRepository.deleteById(id);		
	}


	@Override
	public void deleteAll() {		
		personRepository.deleteAll();
	}

	@Override
	public List<Person> findByName(String name) {
		List<Person> list = new ArrayList<>();
		for(Person p : personRepository.findAll()) {
			if (p.getName().indexOf(name)>-1)
				list.add(p);
		}			
		return list;
	}

	@Override
	public List<Person> findByEmail(String email) {
		List<Person> list = new ArrayList<>();
		for(Person p : personRepository.findAll()) {
			if (p.getEmail().indexOf(email)>-1)
				list.add(p);
		}			
		return list;
	}

	@Override
	public List<Person> findByDescription(String description) {
		List<Person> list = new ArrayList<>();
		for(Person p : personRepository.findAll()) {
			if (p.getDescription().indexOf(description)>-1)
				list.add(p);
		}			
		return list;
	}

	@Override
	public List<Person> findByProject(String nameProject) {
		List<Person> list = new ArrayList<>();
		for(Person p : personRepository.findAll()) {
			if (p.getProject().getName().indexOf(nameProject)>-1)
				list.add(p);
		}			
		return list;		
	}
}
