package dev.lokeshbisht.cachingWithSpringBoot.exceptions;

import java.io.Serial;

public class SubjectNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public SubjectNotFoundException(String message) {
        super(message);
    }
}
