package dev.lokeshbisht.cachingWithSpringBoot.repository;

import dev.lokeshbisht.cachingWithSpringBoot.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findOneByStudentId(Long studentId);
    List<Student> findAllByDepartmentIdIn(List<Long> departmentIdList);
}
