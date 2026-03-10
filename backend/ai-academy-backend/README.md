# AI Academy Backend

This is the backend service for the AI Academy application, built with Spring Boot.

## Prerequisites

- Java 17 or higher
- Maven (or use the included Maven wrapper)

## How to Run

1. Navigate to the backend directory:
   ```
   cd ai-academy-backend/backend
   ```

2. Run the application using Maven wrapper:
   - On Windows: `mvnw.cmd spring-boot:run`
   - On Unix/Linux/Mac: `./mvnw spring-boot:run`

3. The application will start on `http://localhost:8080`

## API Endpoints

The API provides full CRUD operations for courses. Below are the available endpoints with curl examples.

### Get All Courses
```bash
curl -X GET http://localhost:8080/api/courses
```

### Get Course by ID
```bash
curl -X GET http://localhost:8080/api/courses/1
```

### Get Courses by Category
```bash
curl -X GET "http://localhost:8080/api/courses/category/Machine%20Learning"
```

### Create a New Course
```bash
curl -X POST http://localhost:8080/api/courses \
  -H "Content-Type: application/json" \
  -d '{
    "title": "New AI Course",
    "description": "Learn the basics of AI",
    "category": "AI Foundations",
    "trainerId": 1
  }'
```

### Update an Existing Course
```bash
curl -X PUT http://localhost:8080/api/courses/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated AI Course",
    "description": "Advanced AI concepts",
    "category": "Advanced AI",
    "trainerId": 2
  }'
```

### Delete a Course
```bash
curl -X DELETE http://localhost:8080/api/courses/3
```

## Java Version

This project uses Java 17.