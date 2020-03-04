package com.example.demo3.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo3.model.Person;
import com.example.demo3.model.Project;


@Service
public class InitDBService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InitDBService.class);
	
	final PersonService personService;
	final ProjectService projectService;

	
	public InitDBService(PersonService personService, ProjectService projectService) {
		super();
		this.personService = personService;
		this.projectService = projectService;
	}


	public void full(){
		 //проверить наличие базьі, сoздать если ее нет и заполнить
		 if (personService.getAll()!=null)personService.deleteAll();
		 if (projectService.getAll()!=null)projectService.deleteAll();
		 
		 log.info("start init persons");
		 Person person1 = new Person("Tom Soyer","tom.soyer@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person2 = new Person("Gek Fin","gek.fin@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person3 = new Person("Hugo Boss","hugo.boss@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person4 = new Person("Bill Gates","bill.gates@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person5 = new Person("Billy Bons","billy.bons@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person6 = new Person("Will Smith","will.smith@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person7 = new Person("Tom Cruse","tom.cruse@google.com",String.format("Visited at %s", LocalDateTime.now()));		 
		 Person person8 = new Person("Stive Jobs","stive.jobs@google.com",String.format("Visited at %s", LocalDateTime.now()));
		 personService.save(person1);
		 personService.save(person2);
		 personService.save(person3);
		 personService.save(person4);
		 personService.save(person5);
		 personService.save(person6);
		 personService.save(person7);
		 personService.save(person8);
		 	
		 
		 
		 log.info("start init projects");
		 Project project1 = new Project("First Project",String.format("Created at %s", LocalDateTime.now()));
		 List<Person> persons1 = new ArrayList<>();
		 persons1.add(person1);
		 persons1.add(person2);
		 persons1.add(person4);
		 persons1.add(person3);
		 persons1.add(person5);
		 //project1.setPersons(persons1);
		 projectService.save(project1);
		 
		 
		 Project project2 = new Project("Second Project",String.format("Created at %s", LocalDateTime.now()));
		 List<Person> persons2 = new ArrayList<>();		 
		 persons2.add(person6);
		 persons2.add(person7);
		 persons2.add(person8);
		 //project2.setPersons(persons2);
		 projectService.save(project2);	
		 //person8.setProject(project2);
		 
		 long i = 1L;
		 person1 = personService.getById(i);
		 log.info("!!!!!!!"+person1.getName()+" /// "+project1.getName());
		 person1.setProject(project1);
		 //person2.setProject(project1);
		 //person3.setProject(project1);
		 //person4.setProject(project1);
		 //person5.setProject(project1);
		 //person6.setProject(project1);
		 //person7.setProject(project1);
		 log.info("!!!!!!!"+personService.save(person1));
		 log.info("!!!!!!!"+personService.getById(i));
		 
	 }
	
	
}
