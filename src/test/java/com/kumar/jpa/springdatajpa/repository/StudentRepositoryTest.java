package com.kumar.jpa.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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

    @Test
    void should_return_student_list_given_first_name() {
        List<Student> studentListByName = studentRepository.findByFirstName("Sonu");
        assertListSize(studentListByName, 2);
        assertEquals(studentListByName.get(0).getFirstName(), "Sonu");
        assertEquals(studentListByName.get(0).getEmail(), "sonuKumar@gmail.com");
    }
    

    private static void assertListSize(List<?> list, int expectedSize) {
        // Use assert to check the size of the list
        assert list.size() == expectedSize : "List size does not match expected size";
    }
}
