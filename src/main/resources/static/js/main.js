fetch("/api/person/")
.then(response => response.json())
.then(persons => {
	  persons.forEach(person => {
    const el = document.createElement('li');
    el.innerHTML =person.id+":  "+ person.getName() +"  "+ person.getDescription() +'<a href="/api/person/delete'+person.id+'">DELETE</a>';

    document.querySelector('#persons').append(el);
  });
});

fetch("/api/project/9")
.then(response => response.json())
.then(project => {
    const el = document.createElement('li');
    el.innerHTML ="<form action=\"/api/project/"+project.id+"/delete\" method=\"DELETE\" accept-charset=\"utf-8\">"
    				+ project.id+":  "+ project.name +"  "+ project.description 
    				+ "<input type=\"submit\" value=\"delete\"/>"
    				+ '</form>';

    document.querySelector('#project').append(el);
});

fetch("/api/project/")
.then(response => response.json())
.then(projects => {
	projects.forEach(project => {
    const el = document.createElement('li');
    el.innerHTML ="<form action=\"/api/project/"+project.id+"/delete\" method=\"DELETE\" accept-charset=\"utf-8\">"
		+ project.id+":  "+ project.name +"  "+ project.description 
		+ "<input type=\"submit\" value=\"delete\"/>"
		+ '</form>';

    document.querySelector('#projects').append(el);
  });
});