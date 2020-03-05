package com.example.demo3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable{

	   	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    private String name;	    
	    private String description;
	    
	    @OneToMany(cascade = CascadeType.ALL,	            
	           mappedBy="project")
	    private List<Person> persons;    
	    
		//public Project(String name, String description, List<Person> persons) {
		//	super();
		//	this.name = name;
		//	this.description = description;
		//	this.persons = persons;
		//}
	
		public Project(String name, String description) {
			super();
			this.name = name;
			this.description = description;
		}

		public Project(String name) {
			super();
			this.name = name;
		}

		public Project() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		//public List<Person> getPersons() {
		//	return persons;
		//}

		//public void setPersons(List<Person> persons) {
		//	this.persons = persons;
		//}
	    
	    
}
