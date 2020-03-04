package com.example.demo3.service;

import java.util.List;

import com.example.demo3.model.Person;
import com.example.demo3.model.Project;


public interface ProjectService {

	Project save(Project project);
	Project getById(long id);
    List<Project> getAll();
    void delete(long id);

    List<Project> findByName(String name);
    List<Project> findByDescription(String description);

    List<Person> findAllPersonByName(String name);
    
    void deleteAll();
}
