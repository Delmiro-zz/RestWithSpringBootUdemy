package br.com.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.springboot.model.Person;
import br.com.springboot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) throws Exception {
		return personService.findById(id);
	}

	@GetMapping
	public List<Person> findAll() throws Exception {
		return personService.findAll();
	}

	@PostMapping
	public Person createPerson(@RequestBody Person person) throws Exception {
		return personService.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) throws Exception {
		return personService.create(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personService.delete(id);
		return ResponseEntity.ok().build();
	}

}
