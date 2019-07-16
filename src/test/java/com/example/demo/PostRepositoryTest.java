package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void crudRepository() {
        // Given
        Post post = new Post();
        post.setTitle("hello spring boot common");
        assertThat(post.getId()).isNull();

        // when
        Post newPost = postRepository.save(post);

        // then
        assertThat(newPost.getId()).isNotNull();

        // When
        List<Post> posts = postRepository.findAll();

        // Then
        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts).contains(newPost);

        // When
        Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));

        // Then
        assertThat(page.getTotalElements()).isEqualTo(1); // 전체 Element개수
        assertThat(page.getNumber()).isEqualTo(0);      // 현재페이지
        assertThat(page.getSize()).isEqualTo(10);       // 맨 처음에 요청한 10개 (size)
        assertThat(page.getNumberOfElements()).isEqualTo(1);    // 현재 페이지에 들어올 수 있는개수?

        // When
        postRepository.findByTitleContains("spring", PageRequest.of(0, 10));

        // Then
        assertThat(page.getTotalElements()).isEqualTo(1); // 전체 Element개수
        assertThat(page.getNumber()).isEqualTo(0); // 현재페이지
        assertThat(page.getSize()).isEqualTo(10); // 맨 처음에 요청한 10개 (size)
        assertThat(page.getNumberOfElements()).isEqualTo(1); // 현재 페이지에 들어올 수 있는개수?

    }
    
}