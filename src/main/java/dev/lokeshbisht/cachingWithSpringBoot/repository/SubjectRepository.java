package dev.lokeshbisht.cachingWithSpringBoot.repository;

import dev.lokeshbisht.cachingWithSpringBoot.document.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
    Subject findOneBySubjectId(Long subjectId);
}
