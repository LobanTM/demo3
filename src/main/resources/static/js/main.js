fetch("/api/person/")
.then(response => response.json())
.then(persons => {
	  persons.forEach(person => {
    const el = document.createElement('li');
    el.innerText =person.id+":  "+ person.name +"  "+ person.description +'<a href="/api/person/delete">DELETE</a>';

    document.querySelector('#persons').append(el);
  });
});

fetch("/api/project/")
.then(response => response.json())
.then(projects => {
	projects.forEach(project => {
    const el = document.createElement('li');
    el.innerText =project.id+":  "+ project.name +"  "+ project.description + '<a href="/api/project/delete/"'+project.id+'>DELETE</a>';

    document.querySelector('#projects').append(el);
  });
});