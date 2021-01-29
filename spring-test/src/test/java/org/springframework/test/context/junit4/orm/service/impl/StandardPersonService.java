

package org.springframework.test.context.junit4.orm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.orm.domain.Person;
import org.springframework.test.context.junit4.orm.repository.PersonRepository;
import org.springframework.test.context.junit4.orm.service.PersonService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Standard implementation of the {@link PersonService} API.
 *
 * @author Sam Brannen
 * @since 3.0
 */
@Service
@Transactional(readOnly = true)
public class StandardPersonService implements PersonService {

	private final PersonRepository personRepository;


	@Autowired
	public StandardPersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person findByName(String name) {
		return this.personRepository.findByName(name);
	}

	@Override
	@Transactional(readOnly = false)
	public Person save(Person person) {
		return this.personRepository.save(person);
	}

}
