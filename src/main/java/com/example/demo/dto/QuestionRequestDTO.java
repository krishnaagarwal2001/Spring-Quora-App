package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/*
    @Data annotation is used to generate getters, setters, equals, hashCode, and toString methods.
    @Data is equivalent to @Getter @Setter @EqualsAndHashCode @ToString
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequestDTO {
    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 1000, message = "Content must be between 10 and 1000 characters")
    private String content;
}
