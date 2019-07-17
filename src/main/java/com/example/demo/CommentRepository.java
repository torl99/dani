package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends MyRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment AS c", nativeQuery = true)
    List<Comment> findByTitleContains(String keyword);
}