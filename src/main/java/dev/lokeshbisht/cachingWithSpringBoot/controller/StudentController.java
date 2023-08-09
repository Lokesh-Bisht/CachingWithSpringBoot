package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.AddressDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.StudentDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody CreateStudentRequestDto createStudentRequestDto) {
        return studentService.createStudent(createStudentRequestDto);
    }

    @PatchMapping("/student/{studentId}")
    public Student updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId) {
        return studentService.updateStudent(studentDto, studentId);
    }

    @PatchMapping("/student/{studentId}/address")
    public Student updateStudent(@RequestBody AddressDto addressDto, @PathVariable Long studentId) {
        return studentService.updateStudentAddress(addressDto, studentId);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping("/student/all")
    public ApiResponseDto<List<Student>> getAllStudents() {
        return studentService.getAllStudents();
    }
}
