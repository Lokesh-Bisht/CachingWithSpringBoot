package dev.lokeshbisht.cachingWithSpringBoot.dto.instructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class InstructorDto {

    private String name;

    @JsonProperty("dept_name")
    private String deptName;

    private Double salary;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
