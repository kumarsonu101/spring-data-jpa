package com.kumar.jpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterial extends JpaRepository<CourseMaterial, Long> {
    
}
