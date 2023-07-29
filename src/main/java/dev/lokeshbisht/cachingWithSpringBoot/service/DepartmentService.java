package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(DepartmentDto departmentDto);
    Department updateDepartment(DepartmentDto departmentDto, Long departmentId);
    Department getDepartment(Long departmentId);
    ApiResponseDto<List<Department>> getAllDepartments();
    void deleteDepartment(Long departmentId);
}
