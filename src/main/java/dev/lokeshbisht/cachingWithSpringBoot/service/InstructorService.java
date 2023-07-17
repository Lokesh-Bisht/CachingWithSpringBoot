package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;

import java.util.List;

public interface InstructorService {

    Instructor createInstructor(InstructorDto instructorDto);
    Instructor updateInstructor(InstructorDto instructorDto, Long instructorId);
    Instructor getInstructor(Long instructorId);
    ApiResponseDto<List<Instructor>> getAllInstructors();
}
