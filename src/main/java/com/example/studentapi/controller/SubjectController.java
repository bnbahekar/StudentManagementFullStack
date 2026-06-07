package com.example.studentapi.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

import com.example.studentapi.dto.SubjectDTO;
import com.example.studentapi.service.SubjectService;
import com.example.studentapi.util.ApiResponse;



@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse create(@RequestBody SubjectDTO dto) {
        return new ApiResponse("success", "Subject created", service.createSubject(dto));
    }

    @GetMapping
    public ApiResponse getAll() {
        return new ApiResponse("success", "Success", service.getAllSubjects());
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        return new ApiResponse("success", "Success", service.getSubjectById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Integer id, @RequestBody SubjectDTO dto) {
        return new ApiResponse("success", "Updated", service.updateSubject(id, dto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        service.deleteSubject(id);
        return new ApiResponse("success", "Deleted", id);
    }
}