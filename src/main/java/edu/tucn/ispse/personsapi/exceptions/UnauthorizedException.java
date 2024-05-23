package edu.tucn.ispse.personsapi.exceptions;

/**
 * @author Radu Miron
 * @version 1
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
