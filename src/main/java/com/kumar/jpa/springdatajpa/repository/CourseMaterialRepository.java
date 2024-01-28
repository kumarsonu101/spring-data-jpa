package com.kumar.jpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
    
}
