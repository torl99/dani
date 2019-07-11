package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * JpaRunner
 */
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Post post = new Post();
        // post.setTitle("spring Data Jpa 1");

        // Comment comment1 = new Comment();
        // comment1.setComment("1번 comment");
        // post.addComment(comment1);

        // Comment comment2 = new Comment();
        // comment2.setComment("2번 comment");
        // post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 1l);
        session.delete(post);

        // Post post = session.get(Post.class, 1l);
        // session.delete(post);

    }
}