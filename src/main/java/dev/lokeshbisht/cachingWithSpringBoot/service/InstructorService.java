package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;

public interface InstructorService {

    Instructor createInstructor(InstructorDto instructorDto);
    Instructor updateInstructor(InstructorDto instructorDto, Long instructorId);
}
