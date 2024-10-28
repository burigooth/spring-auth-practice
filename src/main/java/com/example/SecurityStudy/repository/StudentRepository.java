package com.example.SecurityStudy.repository;

import com.example.SecurityStudy.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
