package dev.lokeshbisht.cachingWithSpringBoot.repository;

import dev.lokeshbisht.cachingWithSpringBoot.document.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
}
