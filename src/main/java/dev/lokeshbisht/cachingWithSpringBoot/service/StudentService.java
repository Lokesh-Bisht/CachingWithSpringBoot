package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.AddressDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.StudentDto;

import java.util.List;

public interface StudentService {

    Student createStudent(CreateStudentRequestDto createStudentRequestDto);
    Student updateStudent(StudentDto studentDto, Long studentId);
    Student updateStudentAddress(AddressDto addressDto, Long studentId);
    Student getStudent(Long studentId);
    ApiResponseDto<List<Student>> getAllStudents();
}
