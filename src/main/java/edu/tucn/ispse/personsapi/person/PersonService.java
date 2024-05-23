package edu.tucn.ispse.personsapi.person;

import edu.tucn.ispse.personsapi.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Radu Miron
 * @version 1
 */
@Service // creates one instance of this class
@Slf4j // adds the 'log(ger)' instance to this class
public class PersonService {

    @Autowired // injects the PersonRepository instance
    private PersonRepository personRepository;
    @Autowired // injects the PersonMapper instance
    private PersonMapper personMapper;

    @Transactional(rollbackFor = Exception.class) // the method is executed in a transaction
    public PersonDTO create(PersonDTO personDTO) {
        PersonDTO createdPersonDTO =
                personMapper.personToDto(personRepository.save(personMapper.dtoToPerson(personDTO)));

        log.info("Saved a new person with ID Number {} and id {}", createdPersonDTO.getIdNumber(), personDTO.getId());

        return createdPersonDTO;
    }

    @Transactional(rollbackFor = Exception.class) // the method is executed in a transaction
    public PersonDTO update(String idNumber, PersonDTO personDTO) {
        Person person = personRepository.findByIdNumber(idNumber);
        if (person == null) {
            throw new NotFoundException(idNumber + " not found");
        } ;

        Person newPerson = personMapper.dtoToPerson(personDTO);
        newPerson.setId(person.getId());
        if (person.getAddress() != null && newPerson.getAddress() != null) {
            newPerson.getAddress().setId(person.getAddress().getId());
        }

        Person updatedPerson = personRepository.save(newPerson);
        log.info("Updated person with id {}", updatedPerson.getId());

        return personMapper.personToDto(updatedPerson);
    }

    @Transactional(readOnly = true)
    public PersonDTO read(String idNumber) {
        Person person = personRepository.findByIdNumber(idNumber);
        if (person == null) {
            throw new NotFoundException(idNumber + " not found");
        }

        return personMapper.personToDto(person);
    }

    @Transactional(rollbackFor = Exception.class) // the method is executed in a transaction
    public PersonDTO delete(String idNumber) {
        PersonDTO personDTO = read(idNumber);
        personRepository.deleteById(personDTO.getId());
        log.info("Deleted person with id {}", idNumber);
        return personDTO;
    }

    public Set<String> findAllIds() {
        return personRepository.findAll()
                .stream()
                .map(Person::getIdNumber)
                .collect(Collectors.toSet());
    }
}
