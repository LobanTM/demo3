package com.example.demo3.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo3.model.Person;
import com.example.demo3.service.PersonService;

public class ListPersonServlet extends HttpServlet{
	
		final PersonService personService;
		
		
	 	public ListPersonServlet(PersonService personService) {
			super();
			this.personService = personService;
		}

		@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			resp.setContentType("text/html; charset=utf-8");
	 		List<Person> persons = personService.getAll();
	 		resp.getWriter().println("<a href=\"/\">back</a>");
	 		resp.getWriter().println("<h3>List of Persons</h3>");
	 		for(Person p : persons) {
	 			long id = p.getId();
	 			String name = p.getName();
	 			String link = "<a href=\"#\">"+name+"</a>";
	 			
	 			resp.getWriter().println(link);
	            resp.getWriter().println("______________");
	            resp.getWriter().println("<a href=\"/api/person/"+id+"/delete\">Delete</a>");	            
	            
	 		}
	        
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       

	    }
}
