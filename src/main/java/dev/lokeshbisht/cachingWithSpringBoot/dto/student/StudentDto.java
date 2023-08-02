package dev.lokeshbisht.cachingWithSpringBoot.dto.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

import static dev.lokeshbisht.cachingWithSpringBoot.constants.JsonConstants.ISO8601;

@Data
public class StudentDto {

    @JsonProperty("student_name")
    private String name;

    private int age;

    private String gender;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    private String email;

    @JsonProperty("department_id")
    private Long departmentId;

    @JsonProperty("enrollmentDate")
    private Date EnrollmentDate;

    @JsonProperty("address")
    private AddressDto addressDto;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
