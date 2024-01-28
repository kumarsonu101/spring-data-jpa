package com.kumar.jpa.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);

    List<Student> findByGuardianName(String guardianName);
    List<Student> findByFirstNameContaining(String string);

    //JPQL
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Student getStudentByEmailAdress(String email);


//Checkout this page for further queries
//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
} 