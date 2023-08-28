package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    @Qualifier("counterRedisTemplate")
    private RedisTemplate<String, Long> redisTemplate;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate2;

    @Autowired
    private ObjectMapper objectMapper;

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
        List<Object> result = redisTemplate2.opsForList().range("allDepartments", 0, -1);
        if (result == null) {
            result = new ArrayList<>();
        }
        List<Department> departmentList = result.stream()
            .map(item -> objectMapper.convertValue(item, Department.class))
            .collect(Collectors.toList());
        if (departmentList.isEmpty()) {
            logger.info("Fetching departments from database.");
            departmentList = departmentRepository.findAll();
            departmentList.forEach(department -> redisTemplate2.opsForList().leftPush("allDepartments", department));
        }
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
