package com.recipes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException(Class theClass) {
        super("The " + theClass.getSimpleName() + " with the provided information already exists");
    }
}
