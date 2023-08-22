package dev.lokeshbisht.cachingWithSpringBoot.document;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "DepartmentCode is required.")
    private String departmentCode;

    @NotNull(message = "Department name is required.")
    private String departmentName;

    @NotNull(message = "Department head is required.")
    private Long headOfDepartment;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
