package com.kumar.jpa.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
