package com.kumar.jpa.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Course;
import com.kumar.jpa.springdatajpa.entity.Teacher;

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
    
    @Test
    void shoud_save_course_with_course_material_and_teacher() {

       Course course =  Course.builder()
        .title("Springboot")
        .credit(5)
        .teacher(addTeacherDetails())
        .build();

        if(null != course) {
          courseRepository.save(course);
        }

    }

    private Teacher addTeacherDetails() {
      return Teacher.builder()
      .firstName("Priyanka")
      .lastName("Singh")
      .build();
    }

}
