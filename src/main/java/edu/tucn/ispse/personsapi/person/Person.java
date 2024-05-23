package edu.tucn.ispse.personsapi.person;


import edu.tucn.ispse.personsapi.address.Address;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Radu Miron
 * @version 1
 */

@Entity // maps class to DB table, object to table row, attribute to column
@Data // lombok annotation, creates equals(), hashCode() and toString at compile time
public class Person {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;

    @Column(unique=true)
    private String idNumber;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
