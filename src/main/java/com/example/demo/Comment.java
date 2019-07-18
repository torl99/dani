package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

 
    @Id @GeneratedValue
    private Long id;

    private String comment;

    
    private int likeCount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }


    public Post getPost() {
        return post;
    }


    public void setPost(Post post) {
        this.post = post;
    }



    public int getLikeCount() {
        return likeCount;
    }



    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    
}