package com.aiacademy.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseRequest {
    private String title;
    private String description;
    private String category;
    private Long trainerId;
    private Integer durationWeeks;
}
