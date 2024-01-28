package com.kumar.jpa.springdatajpa.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kumar.jpa.springdatajpa.entity.Guardian;
import com.kumar.jpa.springdatajpa.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    Student student;
    Guardian guardian;
    Student studentWithGuardianDetails;

    @BeforeEach
    void return_student_object() {

        guardian = Guardian.builder()
                .name("ABC")
                .email("newEmail@gmail.com")
                .mobile("885585875692")
                .build();

                student = Student.builder()
                .firstName("Sushant")
                .lastName("kumar")
                .email("sonuKumar@gmail.com")
                .build();

        studentWithGuardianDetails = Student.builder()
                .firstName("Sonu")
                .lastName("kumar")
                .email("kumar@gmail.com")
                .guardian(guardian)
                .build();

    }

    @Test
    void should_save_data_given_student_object() {
        studentRepository.save(student);
    }

    @Test
    void should_save_student_with_guardian_data() {
        studentRepository.save(studentWithGuardianDetails);
    }

}
