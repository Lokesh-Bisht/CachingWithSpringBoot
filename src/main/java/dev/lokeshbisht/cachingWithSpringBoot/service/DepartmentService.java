package dev.lokeshbisht.cachingWithSpringBoot.service;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import dev.lokeshbisht.cachingWithSpringBoot.dto.department.DepartmentDto;

public interface DepartmentService {

    Department createDepartment(DepartmentDto departmentDto);
    Department updateDepartment(DepartmentDto departmentDto, Long departmentId);
    Department getDepartment(Long departmentId);
}
