package com.example.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentapi.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}