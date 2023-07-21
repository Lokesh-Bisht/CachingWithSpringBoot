package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public Subject createSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @PutMapping("/subject/{subjectId}")
    public Subject updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable Long subjectId) {
        return subjectService.updateSubject(subjectDto, subjectId);
    }

    @GetMapping("/subject/{subjectId}")
    public Subject getSubject(@PathVariable Long subjectId) {
        return subjectService.getSubject(subjectId);
    }
}
