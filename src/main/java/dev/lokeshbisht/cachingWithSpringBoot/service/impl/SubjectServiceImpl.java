package dev.lokeshbisht.cachingWithSpringBoot.service.impl;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import dev.lokeshbisht.cachingWithSpringBoot.dto.subject.SubjectDto;
import dev.lokeshbisht.cachingWithSpringBoot.exceptions.SubjectNotFoundException;
import dev.lokeshbisht.cachingWithSpringBoot.mapper.SubjectMapper;
import dev.lokeshbisht.cachingWithSpringBoot.repository.SubjectRepository;
import dev.lokeshbisht.cachingWithSpringBoot.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectMapper subjectMapper;

    private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Override
    public Subject createSubject(SubjectDto subjectDto) {
        logger.info("Create subject: {}", subjectDto);
        Subject subject = subjectMapper.toSubject(subjectDto);
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
        Subject updatedSubject = subjectMapper.toSubject(subjectDto);
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
}
