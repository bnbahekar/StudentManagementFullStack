package com.example.studentapi.validator;

import com.example.studentapi.dto.SubjectDTO;

public class SubjectValidator {

    public static void validate(SubjectDTO dto) {

        if (dto.getSubjectName() == null || dto.getSubjectName().trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name is required");
        }

        if (dto.getSubjectCode() == null || dto.getSubjectCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Subject code is required");
        }

        if (dto.getSubjectCode().length() < 3) {
            throw new IllegalArgumentException("Subject code must be at least 3 characters");
        }
    }
}