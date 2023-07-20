package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;

public interface SubjectService {

    Subject createSubject(SubjectDto subjectDto);
    Subject updateSubject(SubjectDto subjectDto, Long subjectId);
}
