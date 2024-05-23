package edu.tucn.ispse.personsapi.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.tucn.ispse.personsapi.address.AddressDTO;
import lombok.Data;

import java.util.Date;

/**
 * @author Radu Miron
 * @version 1
 */

@Data // lombok annotation, creates equals(), hashCode() and toString at compile time
public class PersonDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hides field 'id' for create in swagger
    private Integer id;

    private String idNumber;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private AddressDTO address;
}
