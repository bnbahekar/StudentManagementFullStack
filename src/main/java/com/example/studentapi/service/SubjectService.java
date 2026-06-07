package com.example.studentapi.service;

import java.util.List;
import com.example.studentapi.dto.SubjectDTO;

public interface SubjectService {

    SubjectDTO createSubject(SubjectDTO dto);

    List<SubjectDTO> getAllSubjects();

    SubjectDTO getSubjectById(Integer id);

    SubjectDTO updateSubject(Integer id, SubjectDTO dto);

    void deleteSubject(Integer id);
}