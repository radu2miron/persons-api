package edu.tucn.ispse.personsapi.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByIdNumber(String idNumber);
}
