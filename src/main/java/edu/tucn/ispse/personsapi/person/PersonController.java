package edu.tucn.ispse.personsapi.person;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Radu Miron
 * @version 1
 */
@RestController // creates an instance of the current class
@RequestMapping("/persons") // maps the requests starting with '/positions' to this controller
public class PersonController {

    @Autowired // creates the injection of PositionService instance
    private PersonService personService;

    @PostMapping // maps the '/persons' POST requests to this method
    @Operation(summary = "Save a new person") // swagger description
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @GetMapping("/{idNumber}") // maps the '/persons' GET requests to this method
    @Operation(summary = "Read a person") // swagger description
    public PersonDTO read(@PathVariable(value = "idNumber") String idNumber) {
        return personService.read(idNumber);
    }

    @GetMapping("/findAllIds") // maps the '/persons/findAllIds' GET requests to this method
    @Operation(summary = "Get all id numbers") // swagger description
    public Set<String> findAllIds() {
        return personService.findAllIds();
    }

    @PutMapping("/{idNumber}") // maps the '/persons' PUT requests to this method
    @Operation(summary = "Update a person") // swagger description
    public PersonDTO update(@PathVariable(value = "idNumber") String idNumber,
                            @RequestBody PersonDTO personDTO) {
        return personService.update(idNumber, personDTO);
    }

    @DeleteMapping("/{idNumber}") // maps the '/persons' DELETE requests to this method
    @Operation(summary = "Delete a person") // swagger description
    public PersonDTO delete(@PathVariable(value = "idNumber") String idNumber) {
        return personService.delete(idNumber);
    }
}
