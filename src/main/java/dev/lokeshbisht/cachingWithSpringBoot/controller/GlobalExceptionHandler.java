package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ErrorResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.enums.ErrorCode;
import dev.lokeshbisht.cachingWithSpringBoot.exceptions.InstructorNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleInstructorNotFoundException(InstructorNotFoundException ex) {
        log.error("InstructorNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INSTRUCTOR_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllException(Exception ex) {
        UUID uuid = UUID.randomUUID();
        String message = String.format("Unhandled exception, logged against error id: %s", uuid);
        log.error("Exception: {} {}", message, ex.getClass().getName(), ex);
        log.error(ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
