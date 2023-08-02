package dev.lokeshbisht.cachingWithSpringBoot.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Student {

    @Id
    private String id;

    private String name;

    private int age;

    private String gender;

    private String mobileNumber;

    private String email;

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
