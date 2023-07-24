package dev.lokeshbisht.cachingWithSpringBoot.exceptions;

import java.io.Serial;

public class DepartmentNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
