package com.example.demo3;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo3.model.Person;
import com.example.demo3.model.Project;
import com.example.demo3.service.PersonService;
import com.example.demo3.service.ProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class Demo3ApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonService personService;
	@Autowired
	private ProjectService projectService;
	
	@Before
	public void setUp() throws Exception {
		personService.deleteAll();
		projectService.deleteAll();
	}
	
	@Test
	public void indexControllerShouldReturnHtmlPage() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Projects")));
	}

	@Test
	public void personControllerShouldReturnPerson() throws Exception {
		mockMvc.perform(get("/"));
		
		mockMvc.perform( 
			      get("/api/person/"))			     
			      .andExpect(status().isOk());			      
			      
	}
	
	@Test
	public void findAllPersonsTest() {
		 personService.save(new Person("Will Smith","will.smith@google.com","Java"));
		 personService.save(new Person("Tom Cruse","tom.cruse@google.com","Java"));
		 List<Person> found = personService.getAll();
		 
		 assert found!=null;
		 assert found.get(0)!=null;
	}
	 @Test
	 public void savePersonTest(){
		 Person person = personService.save(new Person("Tom Soyer","tom.soyer@google.com","Java"));
	     Person found = personService.getById(person.getId());

	     assert found!=null;
	     assert found.getName().indexOf("Tom Soyer")>-1;
	 }

		@Test
		public void findAllProjectsTest() {			
			projectService.save(new Project("First Project",String.format("Created at %s", LocalDateTime.now())));
			
			 List<Person> found = personService.getAll();
			 
			 assert found!=null;
			 assert found.get(0)!=null;
		}
		
		 @Test
		 public void saveProjectTest(){
			 Project project = new Project("First Project",String.format("Created at %s", LocalDateTime.now()));
			 projectService.save(project);
			 Project found = projectService.getById(project.getId());

		     assert found!=null;
		     assert found.getName().indexOf("First Project")>-1;
		 }
}
