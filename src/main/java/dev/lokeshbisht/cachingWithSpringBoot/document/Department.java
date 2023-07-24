package dev.lokeshbisht.cachingWithSpringBoot.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Department {

    @Id
    private String id;

    private Long departmentId;

    private String departmentCode;

    private String departmentName;

    private Long headOfDepartment;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
