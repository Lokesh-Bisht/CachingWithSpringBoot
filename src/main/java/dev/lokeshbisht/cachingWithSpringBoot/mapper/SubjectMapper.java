package dev.lokeshbisht.cachingWithSpringBoot.mapper;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectDto subjectDto);
}
