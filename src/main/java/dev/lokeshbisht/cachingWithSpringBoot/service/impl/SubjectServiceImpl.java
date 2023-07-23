package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.ApiResponseDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.MetaDataDto;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;
import dev.lokeshbisht.cachingWithSpringBoot.exceptions.SubjectNotFoundException;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.SubjectMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.SubjectRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    @Qualifier("counterRedisTemplate")
    private RedisTemplate<String, Long> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Override
    public Subject createSubject(SubjectDto subjectDto) {
        logger.info("Create subject: {}", subjectDto);
        Long counter = redisTemplate.opsForValue().increment("subjectCounter");
        if (counter == null) {
            counter = 1L;
            redisTemplate.opsForValue().set("subjectCounter", counter);
        }
        Subject subject = subjectMapper.toSubject(subjectDto, counter);
        subject.setCreatedAt(new Date());
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(SubjectDto subjectDto, Long subjectId) {
        logger.info("Update subject: {} with new info: {}", subjectId, subjectDto);
        Subject subject = subjectRepository.findOneBySubjectId(subjectId);
        if (subject == null) {
            throw new SubjectNotFoundException("Subject not found.");
        }
        Subject updatedSubject = subjectMapper.toSubject(subjectDto, subjectId);
        updatedSubject.setId(subject.getId());
        updatedSubject.setSubjectId(subjectId);
        updatedSubject.setCreatedAt(subject.getCreatedAt());
        updatedSubject.setCreatedBy(subject.getCreatedBy());
        updatedSubject.setUpdatedAt(new Date());
        return subjectRepository.save(updatedSubject);
    }

    @Override
    public Subject getSubject(Long subjectId) {
        logger.info("Get subject with subjectId: {}", subjectId);
        Subject subject = subjectRepository.findOneBySubjectId(subjectId);
        if (subject == null) {
            throw new SubjectNotFoundException("Subject not found.");
        }
        return subject;
    }

    @Override
    public ApiResponseDto<List<Subject>> getAllSubjects() {
        logger.info("Get all subjects.");
        long startTime = System.currentTimeMillis();
        List<Subject> subjectList = subjectRepository.findAll();
        MetaDataDto metaDataDto = MetaDataDto.builder()
            .page(1)
            .size(1)
            .total(subjectList.size())
            .took(System.currentTimeMillis() - startTime)
            .build();
        return new ApiResponseDto<>(subjectList, "OK", metaDataDto);
    }

    @Override
    public void deleteSubjects(Long subjectId) {
        logger.info("Delete subject: {}", subjectId);
        Subject subject = subjectRepository.findOneBySubjectId(subjectId);
        if (subject == null) {
            throw new SubjectNotFoundException("Subject not found.");
        }
        subjectRepository.delete(subject);
    }
}
