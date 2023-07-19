package dev.lokeshbisht.cachingWithSpringBoot.dto.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import static dev.lokeshbisht.cachingWithSpringBoot.constants.JsonConstants.ISO8601;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

    private String name;

    @JsonProperty("subject_code")
    private String code;

    @JsonProperty("course_id")
    private Long courseId;

    @JsonProperty("instructors")
    private List<Long> instructorList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}