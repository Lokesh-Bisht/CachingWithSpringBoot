package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;

import java.util.List;

public interface SubjectService {

    Subject createSubject(SubjectDto subjectDto);
    Subject updateSubject(SubjectDto subjectDto, Long subjectId);
    Subject getSubject(Long subjectId);
    ApiResponseDto<List<Subject>> getAllSubjects();
    void deleteSubjects(Long subjectId);
}
