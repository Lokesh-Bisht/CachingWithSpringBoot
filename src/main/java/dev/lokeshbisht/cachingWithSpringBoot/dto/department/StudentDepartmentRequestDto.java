package dev.lokeshbisht.cachingWithSpringBoot.dto.department;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentDepartmentRequestDto {

    @JsonProperty("department_ids")
    List<Long> departmentIdList;
}
