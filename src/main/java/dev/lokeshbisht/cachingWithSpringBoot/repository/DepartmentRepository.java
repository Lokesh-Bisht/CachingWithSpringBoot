package dev.lokeshbisht.cachingWithSpringBoot.repository;

import dev.lokeshbisht.cachingWithSpringBoot.document.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}
