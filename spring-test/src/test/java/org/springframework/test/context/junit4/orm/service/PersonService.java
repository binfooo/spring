

package org.springframework.test.context.junit4.orm.service;

import org.springframework.test.context.junit4.orm.domain.Person;

/**
 * Person Service API.
 *
 * @author Sam Brannen
 * @since 3.0
 */
public interface PersonService {

	Person findByName(String name);

	Person save(Person person);

}
