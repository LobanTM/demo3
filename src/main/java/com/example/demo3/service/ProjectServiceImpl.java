package com.example.demo3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo3.model.Person;
import com.example.demo3.model.Project;
import com.example.demo3.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProjectServiceImpl.class);
	final ProjectRepository projectRepository;
		
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public Project save(Project project) {		
		return projectRepository.save(project);
	}

	@Override
	public Project getById(long id) {		
		return projectRepository.findById(id).get();
	}

	@Override
	public List<Project> getAll() {
		List<Project> list = new ArrayList<>();
		projectRepository.findAll().forEach(l->list.add(l));
		return list;
	}

	@Override
	public void delete(long id) {
		projectRepository.deleteById(id);		
	}

	@Override
	public List<Project> findByName(String name) {		
		List<Project> list = new ArrayList<>();
		for(Project p : projectRepository.findAll()) {
			if (p.getName().indexOf(name)>-1)
				list.add(p);
		}			
		return list;
	}

	@Override
	public List<Project> findByDescription(String description) {
		List<Project> list = new ArrayList<>();
		for(Project p : projectRepository.findAll()) {
			if (p.getName().indexOf(description)>-1)
				list.add(p);
		}			
		return list;
	}

	@Override
	public void deleteAll() {
		projectRepository.deleteAll();		
	}

	@Override
	public List<Person> findAllPersonByName(String name) {
		//List<Person> list = new ArrayList<>();
		//for(Project p : projectRepository.findAll()) {
		//	if (p.getName().indexOf(name)>-1)
		//		list = p.getPersons();
		//}			
		//return list;
		return null;
	}

}
