package edu.tucn.ispse.personsapi.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Radu Miron
 * @version 1
 */

@Data // lombok annotation, creates equals(), hashCode() and toString at compile time
public class AddressDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hides field 'id' for create in swagger
    private Integer id;

    private String street;

    private String city;

    private String country;
}
