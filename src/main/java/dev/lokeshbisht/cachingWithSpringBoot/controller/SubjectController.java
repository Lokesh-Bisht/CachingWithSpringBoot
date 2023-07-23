package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    @CacheEvict(value = "instructor", key = "'all'")
    public Subject createSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @PutMapping("/subject/{subjectId}")
    @CacheEvict(value = "instructor", key = "'all'")
    public Subject updateSubject(@Valid @RequestBody SubjectDto subjectDto, @PathVariable Long subjectId) {
        return subjectService.updateSubject(subjectDto, subjectId);
    }

    @GetMapping("/subject/{subjectId}")
    public Subject getSubject(@PathVariable Long subjectId) {
        return subjectService.getSubject(subjectId);
    }

    @GetMapping("/subject/all")
    @Cacheable(value = "subjects", key = "'all'")
    public ApiResponseDto<List<Subject>> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @DeleteMapping("/subject/{subjectId}")
    @CacheEvict(value = "subjects", key = "'all'")
    public void deleteSubjects(@PathVariable Long subjectId) {
        subjectService.deleteSubjects(subjectId);
    }
}
