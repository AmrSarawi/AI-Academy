package com.aiacademy.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        System.out.println("\n===========================================");
        System.out.println("🎓 AI Academy Backend API is running!");
        System.out.println("📍 Server: http://localhost:8080");
        System.out.println("\n📚 Available Endpoints:");
        System.out.println("  GET    /api/courses           - Get all courses");
        System.out.println("  GET    /api/courses/{id}      - Get course by ID");
        System.out.println("  GET    /api/courses/category/{category} - Filter by category");
        System.out.println("  GET    /api/courses/open      - Get open courses");
        System.out.println("  POST   /api/courses           - Create new course");
        System.out.println("  PUT    /api/courses/{id}      - Update course");
        System.out.println("  DELETE /api/courses/{id}      - Delete course");
        System.out.println("===========================================\n");
    }
}
