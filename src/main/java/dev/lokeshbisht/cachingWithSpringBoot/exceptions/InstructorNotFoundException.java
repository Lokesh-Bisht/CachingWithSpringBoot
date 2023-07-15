package dev.lokeshbisht.cachingWithSpringBoot.exceptions;

import java.io.Serial;

public class InstructorNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InstructorNotFoundException(String message) {
        super(message);
    }
}
