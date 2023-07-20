package dev.lokeshbisht.cachingWithSpringBoot.mapper;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    Instructor toInstructor(InstructorDto instructorDto, Long instructorId);
}
