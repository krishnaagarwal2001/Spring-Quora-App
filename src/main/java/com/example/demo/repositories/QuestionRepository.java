package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.demo.models.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
    Here <Question, String> is the type of the entity and the type of the id.    
*/
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

    /**
     * Returns a reactive stream (Flux) containing all questions
     * created by the given author.
     *
     * Flux represents a reactive sequence that can emit zero or more elements.
     * It is used for handling multiple items asynchronously (like a List in
     * reactive programming).
     */
    // Flux<Question> findByAuthorId(String authorId);

    /**
     * Returns a reactive publisher (Mono) containing the count of questions
     * created by the given author.
     *
     * Mono represents a reactive stream that emits zero or one element.
     * It is used for handling single asynchronous results (like an Optional in
     * reactive programming).
     */
    // Mono<Long> countByAuthorId(String authorId);

    @Query("{ '$or': [   { 'title': { $regex: ?0, $options: 'i' } }, { 'content':  { $regex: ?0, $options: 'i' } }] }")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String searchTerm, Pageable pageable);
}
