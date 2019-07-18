package com.example.demo;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {


    List<Comment> findByCommentContains(String keyword);
}