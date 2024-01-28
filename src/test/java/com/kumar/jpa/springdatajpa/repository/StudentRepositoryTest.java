package com.kumar.jpa.springdatajpa.repository;

import org.springframework.boot.test.context.SpringBootTest;

import com.kumar.jpa.springdatajpa.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    void should_save_data_given_student_object() {
        Student student = Student.builder()
        .firstName("Sonu")
        .lastName("kumar")
        .email("sonuKumar@gmail.com")
        .guardianName("XYZ")
        .gurdianEmail("guardianEmail@gmail.com")
        .guardianMobile("998877445566")
        .build();
    }
}
