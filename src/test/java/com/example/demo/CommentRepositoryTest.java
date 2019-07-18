package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        Comment comment = new Comment();
        comment.setLikeCount(100);
        comment.setComment("spring data JPA");
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 10);
        assertThat(comments.size()).isEqualTo(1);
    }

}
