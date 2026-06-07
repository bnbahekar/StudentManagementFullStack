package com.example.studentapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.studentapi.dto.SubjectDTO;
import com.example.studentapi.model.Subject;
import com.example.studentapi.repository.SubjectRepository;
import com.example.studentapi.service.SubjectService;
import com.example.studentapi.exception.ResourceNotFoundException;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repo;

    public SubjectServiceImpl(SubjectRepository repo) {
        this.repo = repo;
    }

    @Override
    public SubjectDTO createSubject(SubjectDTO dto) {
        Subject s = new Subject();
        s.setSubjectName(dto.getSubjectName());
        s.setSubjectCode(dto.getSubjectCode());

        Subject saved = repo.save(s);
        return mapToDTO(saved);
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO getSubjectById(Integer id) {
        Subject s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        return mapToDTO(s);
    }

    @Override
    public SubjectDTO updateSubject(Integer id, SubjectDTO dto) {
        Subject s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        s.setSubjectName(dto.getSubjectName());
        s.setSubjectCode(dto.getSubjectCode());

        return mapToDTO(repo.save(s));
    }

    @Override
    public void deleteSubject(Integer id) {
        repo.deleteById(id);
    }

    private SubjectDTO mapToDTO(Subject s) {
        SubjectDTO dto = new SubjectDTO();
        dto.setSubjectId(s.getSubjectId());
        dto.setSubjectName(s.getSubjectName());
        dto.setSubjectCode(s.getSubjectCode());
        return dto;
    }
}