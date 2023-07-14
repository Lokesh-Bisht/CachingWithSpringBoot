package dev.lokeshbisht.cachingWithSpringBoot.dto.instructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

import static dev.lokeshbisht.cachingWithSpringBoot.constants.JsonConstants.ISO8601;

@Data
public class InstructorDto {

    private String name;

    @JsonProperty("dept_name")
    private String deptName;

    private Double salary;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
