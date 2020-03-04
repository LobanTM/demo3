package com.example.demo3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="project_id")
    private Project project;
    
	public Person(String name, String email, String description, Project project) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
		this.project = project;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public Person(String name, String email, String description) {
		super();
		this.name = name;
		this.email = email;
		this.description = description;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", project=" + project + "]";
	}
    
    
}