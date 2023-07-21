package dev.lokeshbisht.cachingWithSpringBoot.dto.subject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Subject id is required.")
    @JsonProperty("subject_id")
    private Long subjectId;

    @NotEmpty(message = "Subject name is required.")
    private String name;

    @NotEmpty(message = "Subject code is required.")
    @JsonProperty("subject_code")
    private String code;

    @NotNull(message = "Course id can't be null.")
    @JsonProperty("course_id")
    private Long courseId;

    private List<Long> instructors;

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
