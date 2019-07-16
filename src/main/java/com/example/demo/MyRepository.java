package com.example.demo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyRepository<T, id extends Serializable> extends Repository<T, id> {

    
    <E extends T> E save(E entity);

    List<T> findAll();

    long count();
}