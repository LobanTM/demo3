package com.example.demo3.service;

import java.util.List;

import com.example.demo3.model.Person;

public interface PersonService {
	Person save(Person person);
	Person getById(long id);
    List<Person> getAll();
    void delete(long id);
    
    List<Person> findByName(String name);   
    List<Person> findByEmail(String email);
    List<Person> findByDescription(String description);

    List<Person> findByProject(String nameProject);
    
    void deleteAll();
}
