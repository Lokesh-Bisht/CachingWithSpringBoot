package dev.lokeshbisht.cachingWithSpringBoot.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document
public class Subject {

    @Id
    private String id;

    private Long subjectId;

    private String name;

    private String code;

    private Long courseId;

    private List<Long> instructors;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
