package com.example.demo;


import java.util.List;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {

        this.createComment(100, "spring data JPA");
        this.createComment(55, "hibernate SPRING");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Future<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("=======================");
        System.out.println("is Done?" + future.isDone());

        // List<Comment> comments = future.get();
        // comments.forEach(System.out::println);

    }

    private void createComment(int LikeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(LikeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }

}
