package edu.tucn.ispse.personsapi.address;

import edu.tucn.ispse.personsapi.person.Person;
import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Radu Miron
 * @version 1
 */

@Entity// maps class to DB table, object to table row, attribute to column
@Data // lombok annotation, creates equals(), hashCode() and toString at compile time
public class Address {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;

    private String street;

    private String city;

    private String country;

    @OneToOne(mappedBy = "address")
    private Person person;
}
