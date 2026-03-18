package com.aiacademy.backend.service;

import com.aiacademy.backend.dto.CourseDTO;
import com.aiacademy.backend.dto.CreateCourseRequest;
import com.aiacademy.backend.exception.BadRequestException;
import com.aiacademy.backend.exception.CourseNotFoundException;
import com.aiacademy.backend.model.Course;
import com.aiacademy.backend.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return convertToDTO(course);
    }

    public List<CourseDTO> getCoursesByCategory(String category) {
        return courseRepository.findByCategory(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO createCourse(CreateCourseRequest request) {
        // Basic validation
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty");
        }
        if (request.getDurationWeeks() == null || request.getDurationWeeks() <= 0) {
            throw new BadRequestException("Duration weeks must be greater than 0");
        }

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setCategory(request.getCategory());
        course.setTrainerId(request.getTrainerId());
        course.setDurationWeeks(request.getDurationWeeks());

        Course savedCourse = courseRepository.save(course);
        return convertToDTO(savedCourse);
    }

    public CourseDTO updateCourse(Long id, CreateCourseRequest request) {
        // Basic validation
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty");
        }
        if (request.getDurationWeeks() == null || request.getDurationWeeks() <= 0) {
            throw new BadRequestException("Duration weeks must be greater than 0");
        }

        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));

        existingCourse.setTitle(request.getTitle());
        existingCourse.setDescription(request.getDescription());
        existingCourse.setCategory(request.getCategory());
        existingCourse.setTrainerId(request.getTrainerId());
        existingCourse.setDurationWeeks(request.getDurationWeeks());

        Course updatedCourse = courseRepository.save(existingCourse);
        return convertToDTO(updatedCourse);
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setCategory(course.getCategory());
        dto.setTrainerId(course.getTrainerId());
        dto.setDurationWeeks(course.getDurationWeeks());
        return dto;
    }
}
