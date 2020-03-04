package com.example.demo3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
