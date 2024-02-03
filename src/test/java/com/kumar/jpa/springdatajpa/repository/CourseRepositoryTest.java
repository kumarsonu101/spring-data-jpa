package com.kumar.jpa.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Course;

@SpringBootTest
public class CourseRepositoryTest {


    @Autowired
    CourseRepository courseRepository;

    @Test
    void should_return_course_with_course_material() {
      List<Course> course =  courseRepository.findAll();
      System.out.println("Here is what is fetched" + course);
      assertEquals(course.get(0).getTitle(), "DSA");
    }


}
