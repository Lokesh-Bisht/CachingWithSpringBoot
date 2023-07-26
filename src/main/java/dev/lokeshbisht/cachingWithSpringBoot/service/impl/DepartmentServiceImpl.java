package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import dev.lokeshbisht.cachingWithSpringBoot.dto.department.DepartmentDto;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.DepartmentMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.DepartmentRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public Department createDepartment(DepartmentDto departmentDto) {
        logger.info("Create new department: {}", departmentDto);
        Department department = departmentMapper.toDepartment(departmentDto);
        department.setCreatedAt(new Date());
        return departmentRepository.save(department);
    }
}
