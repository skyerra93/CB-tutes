package com.example.app1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(path = "save", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		personRepository.save(person);
		return person;
		
	}
	
	@RequestMapping(path = "savePersons", method = RequestMethod.POST)
	public String savePersons(@RequestBody AllPersons allpersons) {
		personRepository.saveAll(allpersons.getPersons());
		return "success";
		
	}
	
	@RequestMapping(path = "update", method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		personRepository.save(person);
		return person;
		
	}
	
	@RequestMapping(path = "patch", method = RequestMethod.PATCH)
	public Person patching(@RequestBody Person person) {
		Person dbPerson = personRepository.findById(person.getId()).get();
		if (person.getFirstName() != null) {
			dbPerson.setFirstName(person.getFirstName());
		}
		if (person.getLastName() != null) {
			dbPerson.setLastName(person.getLastName());
		}
		personRepository.save(dbPerson);
		return dbPerson;

	}
	
	@RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
	public Integer delete(@PathVariable Integer id) {
		personRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(path = "read/{id}", method = RequestMethod.GET)
	public Person read(@PathVariable Integer id) {
		return personRepository.findById(id).get();
		
	}
	@RequestMapping(path = "readall", method = RequestMethod.GET)
	public List<Person> readAll(){
		return (List<Person>) personRepository.findAll();
		
	}
	

}
