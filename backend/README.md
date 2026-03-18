# AI Academy Backend

A Spring Boot REST API for managing AI Academy courses.

## Prerequisites

- **Java**: JDK 17 or higher
- **Maven**: Included via Maven Wrapper (`mvnw.cmd`)

## Installation

1. Clone the repository
2. Navigate to the backend directory:
   ```bash
   cd backend
   ```

## Running the Application

1. Ensure Java 17+ is installed and `JAVA_HOME` is set
2. Run the application:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```
3. The API will be available at: `http://localhost:8080`

## API Endpoints

### Get All Courses
```bash
curl.exe -X GET "http://localhost:8080/api/courses" -H "accept: application/json"
```

### Get Course by ID
```bash
curl.exe -X GET "http://localhost:8080/api/courses/1" -H "accept: application/json"
```

### Get Courses by Category
```bash
curl.exe -X GET "http://localhost:8080/api/courses/category/AI%20Foundations" -H "accept: application/json"
```

### Create New Course
```bash
curl.exe -X POST "http://localhost:8080/api/courses" ^
  -H "accept: application/json" ^
  -H "Content-Type: application/json" ^
  -d "{ \"title\": \"New AI Course\", \"description\": \"Course description\", \"category\": \"AI\", \"trainerId\": 1, \"durationWeeks\": 8 }"
```

### Update Course
```bash
curl.exe -X PUT "http://localhost:8080/api/courses/1" ^
  -H "accept: application/json" ^
  -H "Content-Type: application/json" ^
  -d "{ \"title\": \"Updated Course Title\", \"description\": \"Updated description\", \"category\": \"AI\", \"trainerId\": 1, \"durationWeeks\": 10 }"
```

### Delete Course
```bash
curl.exe -X DELETE "http://localhost:8080/api/courses/1" -H "accept: application/json"
```

## Course Model

```json
{
  "id": 1,
  "title": "Course Title",
  "description": "Course description",
  "category": "Category",
  "trainerId": 1,
  "durationWeeks": 6
}
```

## Validation

- **Title**: Cannot be empty
- **Duration Weeks**: Must be greater than 0

## Error Responses

### Bad Request (400)
```json
{
  "timestamp": "2026-03-18T...",
  "status": 400,
  "error": "Bad Request",
  "message": "Title cannot be empty"
}
```

### Not Found (404)
```json
{
  "timestamp": "2026-03-18T...",
  "status": 404,
  "error": "Not Found",
  "message": "Course not found with id: 1"
}
```

## Testing

Run tests:
```bash
.\mvnw.cmd test
```

## CORS

The API allows requests from `http://localhost:4200` (for frontend integration).</content>
<parameter name="filePath">c:\Users\AZ\Documents\ai_academy\backend\README.md