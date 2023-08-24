package dev.lokeshbisht.cachingWithSpringBoot.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document
public class Subject implements Serializable {

    @Id
    private String id;

    private Long subjectId;

    @NotBlank(message = "Subject name is required.")
    private String name;

    @NotBlank(message = "Subject code is required.")
    private String code;

    @NotNull(message = "Course ID is required.")
    private Long courseId;

    private List<Long> instructors;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
