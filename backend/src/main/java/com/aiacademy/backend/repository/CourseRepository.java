package com.aiacademy.backend.repository;

import com.aiacademy.backend.model.Course;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    private final Map<Long, Course> courses = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(7);

    public CourseRepository() {
        initializeData();
    }

    private void initializeData() {
        courses.put(1L, new Course(
            1L,
            "AI Fundamentals: From Zero to Intelligent Systems",
            "A hands-on introduction to core AI concepts, tools, and real-world applications.",
            "AI Foundations",
            1L,
            6
        ));

        courses.put(2L, new Course(
            2L,
            "Machine Learning in Practice",
            "Build and evaluate supervised and unsupervised ML models using scikit-learn.",
            "Machine Learning",
            2L,
            8
        ));

        courses.put(3L, new Course(
            3L,
            "Data Science Bootcamp",
            "Master the full data science workflow: collection, cleaning, analysis, and storytelling.",
            "Data Science",
            3L,
            10
        ));

        courses.put(4L, new Course(
            4L,
            "Generative AI & Large Language Models",
            "Explore the architecture behind LLMs and build applications using OpenAI and Hugging Face.",
            "Generative AI & LLMs",
            1L,
            6
        ));

        courses.put(5L, new Course(
            5L,
            "Computer Vision Workshop: Images & Video AI",
            "Hands-on workshop covering CNNs, object detection, and real-time video analysis.",
            "Specialized Workshops",
            2L,
            1
        ));

        courses.put(6L, new Course(
            6L,
            "AI for Organizations: Corporate Training Program",
            "Tailored AI literacy and application training for teams and enterprises.",
            "Corporate Training",
            3L,
            4
        ));
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(courses.get(id));
    }

    public List<Course> findByCategory(String category) {
        return courses.values().stream()
                .filter(course -> course.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            course.setId(idCounter.getAndIncrement());
        }
        courses.put(course.getId(), course);
        return course;
    }

    public void deleteById(Long id) {
        courses.remove(id);
    }

    public boolean existsById(Long id) {
        return courses.containsKey(id);
    }
}
