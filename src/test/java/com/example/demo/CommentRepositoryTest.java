package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

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
        // Optional<Comment> byId = commentRepository.findById(100l);
        // assertThat(byId).isEmpty(); // optional 체크
        // Comment comment = byId.orElseThrow(IllegalArgumentException::new);
    }
    
}