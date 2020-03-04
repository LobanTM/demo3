package com.example.demo3.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.model.Project;
import com.example.demo3.service.PersonServiceImpl;
import com.example.demo3.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProjectController.class);
	final ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	
	@GetMapping("/")
    public Iterable<Project> getProjects() {        
        return projectService.getAll();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Project> getProject(@PathVariable("id") long id){
	   Project project = projectService.getById(id);
	   if (project == null){
	       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	   return new ResponseEntity<>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Project> addProject(@RequestBody String name){
		Project project = new Project(name,String.format("Added at %s", LocalDateTime.now()));
		
		projectService.save(project);
	    return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Void> updateProject(@RequestBody Project project){
    	Project existingProject = projectService.getById(project.getId());
        if (existingProject == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        else {
        	projectService.save(project);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") long id){
    	Project project = projectService.getById(id);
        if (project == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
        	projectService.delete(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        }
    }  
	
}
