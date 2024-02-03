package com.kumar.jpa.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kumar.jpa.springdatajpa.entity.Course;
import com.kumar.jpa.springdatajpa.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    void should_save_course_with_course_material() {
        Course course = Course.builder()
        .title("DSA")
        .credit(6)
        .build();
       CourseMaterial  courseMaterial =  CourseMaterial.builder()
        .url("www.google.com")
        .Course(course)
        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void fetchCourseMaterial() {
       List<CourseMaterial> courseMaterial =  courseMaterialRepository.findAll();
       System.out.println("Course Material" + courseMaterial);

    }
}
