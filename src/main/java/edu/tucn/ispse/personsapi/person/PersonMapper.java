package edu.tucn.ispse.personsapi.person;

import edu.tucn.ispse.personsapi.address.Address;
import edu.tucn.ispse.personsapi.address.AddressDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Radu Miron
 * @version 1
 */

@Component // creates one instance of this class
@Slf4j // adds the 'log(ger)' instance to this class
public class PersonMapper {
    public PersonDTO personToDto(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setIdNumber(person.getIdNumber());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setDateOfBirth(person.getDateOfBirth());
        personDTO.setAddress(addressToDto(person.getAddress()));
        return personDTO;
    }

    public AddressDTO addressToDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    public Person dtoToPerson(PersonDTO pDTO) {
        Person person = new Person();
        person.setId(pDTO.getId());
        person.setIdNumber(pDTO.getIdNumber());
        person.setFirstName(pDTO.getFirstName());
        person.setLastName(pDTO.getLastName());
        person.setDateOfBirth(pDTO.getDateOfBirth());
        person.setAddress(dtoToAddress(pDTO.getAddress()));
        return person;
    }

    public Address dtoToAddress(AddressDTO aDTO) {
        Address address = new Address();
        address.setId(aDTO.getId());
        address.setStreet(aDTO.getStreet());
        address.setCity(aDTO.getCity());
        address.setCountry(aDTO.getCountry());
        return address;
    }

}
