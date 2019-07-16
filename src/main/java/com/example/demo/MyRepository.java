package com.example.demo;

import java.io.Serializable;
import java.util.*;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    
    <E extends T> E save(E entity);

    List<T> findAll();

    long count();
    <E extends T> Optional<E> findById(Id id);
}