package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/instructor")
    @CacheEvict(value = "instructor", key = "'all'")
    public Instructor createInstructor(@RequestBody InstructorDto instructorDto) {
        return instructorService.createInstructor(instructorDto);
    }

    @PutMapping("/instructor/{instructorId}")
    @CacheEvict(value = "instructor", key = "'all'")
    public Instructor updateInstructor(@RequestBody InstructorDto instructorDto, @PathVariable Long instructorId) {
        return instructorService.updateInstructor(instructorDto, instructorId);
    }

    @GetMapping("/instructor/{instructorId}")
    public Instructor getInstructor(@PathVariable Long instructorId) {
        return instructorService.getInstructor(instructorId);
    }

    @GetMapping("/instructor/all")
    @Cacheable(value = "instructor", key = "'all'")
    public ApiResponseDto<List<Instructor>> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @DeleteMapping("/instructor/{instructorId}")
    @CacheEvict(value = "instructor", key = "'all'")
    public void deleteInstructor(@PathVariable Long instructorId) {
        instructorService.deleteInstructor(instructorId);
    }
}
