package com.kumar.jpa.springdatajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Student;
import com.kumar.jpa.springdatajpa.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

   
}