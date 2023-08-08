package dev.lokeshbisht.cachingWithSpringBoot.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
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
    private Date enrollmentDate;
}
