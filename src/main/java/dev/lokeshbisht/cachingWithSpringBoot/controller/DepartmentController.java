package dev.lokeshbisht.cachingWithSpringBoot.controller;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.department.DepartmentDto;
import dev.lokeshbisht.cachingWithSpringBoot.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        return departmentService.createDepartment(departmentDto);
    }

    @PutMapping("/department/{departmentId}")
    public Department updateDepartment(@Valid @RequestBody DepartmentDto departmentDto, @PathVariable Long departmentId) {
        return departmentService.updateDepartment(departmentDto, departmentId);
    }

    @GetMapping("/department/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @GetMapping("/department/all")
    public ApiResponseDto<List<Department>> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/department/{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
