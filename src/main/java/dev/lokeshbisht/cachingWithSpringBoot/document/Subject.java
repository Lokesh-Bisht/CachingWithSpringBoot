package dev.lokeshbisht.cachingWithSpringBoot.document;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Subject {

    private String name;

    private String code;

    private Long courseId;

    private List<Long> instructors;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
