package com.yeditepe.swaggerusage.repository;

import com.yeditepe.swaggerusage.entity.Student;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends
        CrudRepository<Student, UUID> {

    public Optional<Student> findById(UUID id);
}
