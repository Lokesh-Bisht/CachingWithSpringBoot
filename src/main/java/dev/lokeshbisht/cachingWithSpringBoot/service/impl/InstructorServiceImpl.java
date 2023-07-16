package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import dev.lokeshbisht.cachingWithSpringBoot.dto.instructor.InstructorDto;
import dev.lokeshbisht.cachingWithSpringBoot.exceptions.InstructorNotFoundException;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.InstructorMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.InstructorRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorMapper instructorMapper;

    @Autowired
    @Qualifier("counterRedisTemplate")
    private RedisTemplate<String, Long> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(InstructorServiceImpl.class);

    @Override
    public Instructor createInstructor(InstructorDto instructorDto) {
        logger.info("Save instructor: {}", instructorDto);
        Long counter = redisTemplate.opsForValue().increment("instructorCounter");
        if (counter == null) {
            counter = 1L;
            redisTemplate.opsForValue().set("instructorCounter", counter);
        }
        Instructor instructor = instructorMapper.toInstructor(instructorDto, counter);
        instructor.setCreatedAt(new Date());
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(InstructorDto instructorDto, Long instructorId) {
        logger.info("Update instructor {}, with new info: {}", instructorId, instructorDto);
        Instructor instructor = instructorRepository.findOneByInstructorId(instructorId);
        if (instructor == null) {
            logger.error("Instructor not found");
            throw new InstructorNotFoundException("Requested invalid instructor's info.");
        }
        Instructor updatedInstructorInfo = instructorMapper.toInstructor(instructorDto, instructorId);
        updatedInstructorInfo.setId(instructor.getId());
        updatedInstructorInfo.setCreatedBy(instructor.getCreatedBy());
        updatedInstructorInfo.setCreatedAt(instructor.getCreatedAt());
        updatedInstructorInfo.setUpdatedAt(new Date());
        return instructorRepository.save(updatedInstructorInfo);
    }
}
