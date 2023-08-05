package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;

public interface StudentService {

    Student createStudent(CreateStudentRequestDto createStudentRequestDto);
}
