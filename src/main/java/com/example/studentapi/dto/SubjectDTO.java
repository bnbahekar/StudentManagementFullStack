package com.example.studentapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubjectDTO {

    private Integer subjectId;

    @NotBlank(message = "subjectName required")
    private String subjectName;

    @NotBlank(message = "subjectCode required")
    private String subjectCode;
}
