package com.aiacademy.backend.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Integer id) {
        super("Course not found with id: " + id);
    }
}