package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.MetaDataDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.department.DepartmentDto;
import dev.lokeshbisht.cachingWithSpringBoot.exceptions.DepartmentNotFoundException;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.DepartmentMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.DepartmentRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    @Qualifier("counterRedisTemplate")
    private RedisTemplate<String, Long> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public Department createDepartment(DepartmentDto departmentDto) {
        logger.info("Create new department: {}", departmentDto);
        Long counter = redisTemplate.opsForValue().increment("departmentCounter");
        if (counter == null) {
            counter = 1L;
            redisTemplate.opsForValue().set("departmentCounter", counter);
        }
        Department department = departmentMapper.toDepartment(departmentDto, counter);
        department.setCreatedAt(new Date());
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(DepartmentDto departmentDto, Long departmentId) {
        logger.info("Update department: {}, info: {}", departmentId, departmentDto);
        Department department = departmentRepository.findOneByDepartmentId(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found!");
        }
        Department updatedDepartmentInfo = departmentMapper.toDepartment(departmentDto, departmentId);
        updatedDepartmentInfo.setId(department.getId());
        updatedDepartmentInfo.setCreatedBy(department.getCreatedBy());
        updatedDepartmentInfo.setCreatedAt(department.getCreatedAt());
        updatedDepartmentInfo.setUpdatedAt(new Date());
        return departmentRepository.save(updatedDepartmentInfo);
    }

    @Override
    public Department getDepartment(Long departmentId) {
        logger.info("Get department: {}", departmentId);
        Department department = departmentRepository.findOneByDepartmentId(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found!");
        }
        return department;
    }

    @Override
    public ApiResponseDto<List<Department>> getAllDepartments() {
        logger.info("Fetch all departments.");
        long startTime = System.currentTimeMillis();
        List<Department> departmentList = departmentRepository.findAll();
        MetaDataDto metaDataDto = MetaDataDto.builder()
            .page(1)
            .size(1)
            .total(departmentList.size())
            .took(System.currentTimeMillis() - startTime)
            .build();
        return new ApiResponseDto<>(departmentList, "OK", metaDataDto);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        logger.info("Delete department: {}", departmentId);
        Department department = departmentRepository.findOneByDepartmentId(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found!");
        }
        departmentRepository.delete(department);
    }
}
