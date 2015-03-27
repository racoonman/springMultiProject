package org.racoonman.modelanddao.dao;

import java.util.List;
import org.racoonman.modelanddao.model.Person;
import org.springframework.stereotype.Component;

/**
 *
 * @author daniel
 */
public interface PersonsDao {
    List<Person> getPersons();
    public void savePerson(Person c);
    public Person searchByUsername(String username);
}
