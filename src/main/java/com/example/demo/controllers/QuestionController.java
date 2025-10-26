package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.QuestionRequestDTO;
// import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDTO;
// import com.example.demo.models.QuestionElasticDocument;
import com.example.demo.services.IQuestionService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
                .doOnError(error -> System.out.println("Error creating Question: " + error));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping
    public Flux<QuestionResponseDTO> getAllQuestions() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteQuestionById(@PathVariable String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDTO> searchQuestions(
            @RequestParam String query, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("/tag/{tag}")
    public Flux<QuestionResponseDTO> getQuestionsByTag(
            @RequestParam String tag, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
