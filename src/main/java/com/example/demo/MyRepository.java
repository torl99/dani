package com.example.demo;

import java.io.Serializable;
import java.util.*;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.Nullable;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    
    <E extends T> E save(@Nullable E entity);

    List<T> findAll();

    long count();
    
    @Nullable
    <E extends T> E findById(Id id);
}