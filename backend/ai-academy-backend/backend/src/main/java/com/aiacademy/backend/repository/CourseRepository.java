package com.aiacademy.backend.repository;

import com.aiacademy.backend.model.Course;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    private final Map<Integer, Course> courses = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(7);

    public CourseRepository() {
        initializeData();
    }

    private void initializeData() {
        courses.put(1, new Course(
            1,
            "AI Fundamentals: From Zero to Intelligent Systems",
            "A hands-on introduction to core AI concepts, tools, and real-world applications.",
            "AI Foundations",
            1
        ));

        courses.put(2, new Course(
            2,
            "Machine Learning in Practice",
            "Build and evaluate supervised and unsupervised ML models using scikit-learn.",
            "Machine Learning",
            2
        ));

        courses.put(3, new Course(
            3,
            "Data Science Bootcamp",
            "Master the full data science workflow: collection, cleaning, analysis, and storytelling.",
            "Data Science",
            3
        ));

        courses.put(4, new Course(
            4,
            "Generative AI & Large Language Models",
            "Explore the architecture behind LLMs and build applications using OpenAI and Hugging Face.",
            "Generative AI & LLMs",
            1
        ));

        courses.put(5, new Course(
            5,
            "Computer Vision Workshop: Images & Video AI",
            "Hands-on workshop covering CNNs, object detection, and real-time video analysis.",
            "Specialized Workshops",
            2
        ));

        courses.put(6, new Course(
            6,
            "AI Ethics & Responsible Innovation",
            "Examine the societal impacts of AI and learn frameworks for ethical AI development.",
            "AI Ethics",
            3
        ));

        courses.put(7, new Course(
            7,
            "MLOps: Production-Ready Machine Learning",
            "Learn to deploy, monitor, and maintain ML models in production environments.",
            "MLOps",
            1
        ));
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    public Optional<Course> findById(Integer id) {
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

    public void deleteById(Integer id) {
        courses.remove(id);
    }

    public boolean existsById(Integer id) {
        return courses.containsKey(id);
    }
}