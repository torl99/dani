package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Dani dani;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // postRepository.findAll().forEach(System.out::println);
        System.out.println("======================");
        System.out.println(dani.getName());
    }
}