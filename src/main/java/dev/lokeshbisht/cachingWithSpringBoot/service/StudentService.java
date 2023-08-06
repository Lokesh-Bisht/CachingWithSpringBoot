package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.StudentDto;

public interface StudentService {

    Student createStudent(CreateStudentRequestDto createStudentRequestDto);
    Student updateStudent(StudentDto studentDto, Long studentId);
    Student getStudent(Long studentId);
}
