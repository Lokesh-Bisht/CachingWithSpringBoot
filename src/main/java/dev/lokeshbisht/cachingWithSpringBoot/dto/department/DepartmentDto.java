package dev.lokeshbisht.cachingWithSpringBoot.dto.department;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static dev.lokeshbisht.cachingWithSpringBoot.constants.JsonConstants.ISO8601;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    @JsonProperty("department_code")
    private String departmentCode;

    @JsonProperty("department_name")
    private String departmentName;

    @JsonProperty("head_of_department")
    private Long headOfDepartment;

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
