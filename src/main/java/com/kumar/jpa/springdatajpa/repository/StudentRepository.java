package com.kumar.jpa.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);

    //List<Student> findByLastNameNotNull(String lastName);

    List<Student> findByGuardianName(String guardianName);


    
} 