package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody InstructorDto instructorDto) {
        return instructorService.createInstructor(instructorDto);
    }

    @PutMapping("/instructor/{instructorId}")
    public Instructor updateInstructor(@RequestBody InstructorDto instructorDto, @PathVariable Long instructorId) {
        return instructorService.updateInstructor(instructorDto, instructorId);
    }
}
