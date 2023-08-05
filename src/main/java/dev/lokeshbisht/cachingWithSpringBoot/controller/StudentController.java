package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.StudentDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId) {
        return studentService.updateStudent(studentDto, studentId);
    }
}
