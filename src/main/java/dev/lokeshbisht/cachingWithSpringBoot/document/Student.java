package dev.lokeshbisht.cachingWithSpringBoot.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Student {

    @Id
    private String id;

    private Long studentId;

    @NotBlank(message = "Student name is required.")
    private String name;

    @NotNull(message = "Age is required.")
    private int age;

    private String gender;

    @NotBlank(message = "Mobile number is required.")
    private String mobileNumber;

    @NotBlank(message = "Student's email is required.")
    private String email;

    @NotNull(message = "Department id is required.")
    private Long departmentId;

    private Date EnrollmentDate;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
