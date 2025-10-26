package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Size;

/**
 * { @Document(collection = "questions")} marks the class as a MongoDB document.
 * It tells Spring Data to map objects of this class to the "questions"
 * collection in MongoDB.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "questions")
public class Question {
    @Id
    private String id;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 1000, message = "Content must be between 10 and 1000 characters")
    private String content;

    private Integer views;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
