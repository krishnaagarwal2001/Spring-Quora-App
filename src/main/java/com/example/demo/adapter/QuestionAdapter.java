package com.example.demo.adapter;

import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDTO;
import com.example.demo.models.Question;

import java.time.LocalDateTime;

public class QuestionAdapter {
    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .content(question.getContent())
                .title(question.getTitle())
                .createdAt(question.getCreatedAt())
                .build();
    }

    public static Question toQuestion(QuestionRequestDTO requestDTO) {
        return Question.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
