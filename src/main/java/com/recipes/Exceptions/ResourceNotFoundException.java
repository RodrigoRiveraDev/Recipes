package com.recipes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(Class theClass, long id) {
        super("The " + theClass.getSimpleName() + " with id " + id + " was not found");
    }
}
