package com.example.demo3;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo3.model.Person;
import com.example.demo3.repository.PersonRepository;
import com.example.demo3.rest.PersonController;
import com.example.demo3.service.InitDBService;
import com.example.demo3.service.PersonService;

@Controller
public class IndexController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);	
	final PersonService personService;
	final InitDBService initDBService;
	    
	public IndexController(PersonService personService, InitDBService initDBService) {
		super();
		this.personService = personService;
		this.initDBService = initDBService;
	}

	@GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "and person");
        List<Person> persons = personService.getAll();
        if(persons.isEmpty())
        	initDBService.full();
        //Person person = new Person();
        //person.setName("Tom");
        //person.setEmail("tom@mail.com");
        //person.setDescription(String.format("Visited at %s", LocalDateTime.now()));
        //personRepository.save(person);
        //personService.save(person);
        
        return new ModelAndView("index", model);
    }

	
}
