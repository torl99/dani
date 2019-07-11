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
        Account account = new Account();
        account.setUsername("DANI2");
        account.setPassword("PASS2");

        Study study = new Study();
        study.setName("SPRING JPA STUDY");

        account.addStudy(study);
        
        // account.getStudies().add(study);
        // study.setOwner(account);
 
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account dani = session.load(Account.class, account.getId());
        dani.setUsername("dani's spring");
        dani.setUsername("dani's spring2");
        dani.setUsername("DANI2");
        System.out.println("==================================");
        System.out.println(dani.getUsername());
    }
}