package dev.lokeshbisht.cachingWithSpringBoot.dto.instructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

import static dev.lokeshbisht.cachingWithSpringBoot.constants.JsonConstants.ISO8601;

@Data
public class InstructorDto {

    @NotEmpty(message = "Instructor name is required.")
    private String name;

    @NotEmpty(message = "Department name is required.")
    @JsonProperty("dept_name")
    private String deptName;

    @NotNull(message = "Enter a valid salary.")
    @Positive(message = "Salary should be greater than 0.")
    @Min(message = "Salary should be at least $10000.", value = 10000)
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
