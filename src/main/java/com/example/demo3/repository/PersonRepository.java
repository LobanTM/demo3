package com.example.demo3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
