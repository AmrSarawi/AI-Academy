package com.aiacademy.backend.dto;

public class CreateCourseRequest {
    private String title;
    private String description;
    private String category;
    private Integer trainerId;

    public CreateCourseRequest() {}

    public CreateCourseRequest(String title, String description, String category, Integer trainerId) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.trainerId = trainerId;
    }

    // getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Integer getTrainerId() { return trainerId; }
    public void setTrainerId(Integer trainerId) { this.trainerId = trainerId; }
}