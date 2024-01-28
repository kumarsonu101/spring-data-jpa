package com.kumar.jpa.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameContaining(String string);

    // JPQL
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Student getStudentByEmailAdress(String email);

    // Native
    @Query(value = "select * from tbl_student s where s.email = ?1", nativeQuery = true)
    Student getStudentFirstNameByEmailAdress(String email);

    // NativeWithParam
    @Query(value = "select * from tbl_student s where s.email = :email", nativeQuery = true)
    Student getStudentFirstNameByEmailAdressWithParam(@Param("email") String email);

    // NativeWithParam
    @Modifying
    @Transactional
    @Query(value = "update tbl_student SET first_name = :firstName where email = :email", nativeQuery = true)
    int updateStudentByEmailId(@Param("firstName") String firstName, @Param("email") String email);

    // Checkout this page for further queries
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}