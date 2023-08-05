package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import dev.lokeshbisht.cachingWithSpringBoot.dto.student.CreateStudentRequestDto;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.StudentMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.StudentRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    @Qualifier("counterRedisTemplate")
    private RedisTemplate<String, Long> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student createStudent(CreateStudentRequestDto createStudentRequestDto) {
        logger.info("Start - createStudent {}", createStudentRequestDto);
        Long counter = redisTemplate.opsForValue().increment("studentCounter");
        if (counter == null) {
            counter = 1L;
            redisTemplate.opsForValue().set("studentCounter", counter);
        }
        Student student = studentMapper.toStudent(createStudentRequestDto.getStudentDto(), createStudentRequestDto.getAddressDto(), createStudentRequestDto.getCreatedBy(), createStudentRequestDto.getUpdatedBy(), counter);
        student.setCreatedAt(new Date());
        logger.info("Complete - createStudent");
        return studentRepository.save(student);
    }
}
