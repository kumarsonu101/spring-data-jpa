package com.kumar.jpa.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.kumar.jpa.springdatajpa.entity.Course;
import com.kumar.jpa.springdatajpa.entity.Student;
import com.kumar.jpa.springdatajpa.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {


    @Autowired
    CourseRepository courseRepository;

    // @Test
    // void should_return_course_with_course_material() {
    //   List<Course> course =  courseRepository.findAll();
    //   assertEquals(course.get(0).getTitle(), "DSA");
    // }
    
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

    @Test
    void findAllPagination() {
      org.springframework.data.domain.Pageable firstPageWithThreeRecord = PageRequest.of(0, 3);
      org.springframework.data.domain.Pageable secondPageWithTwoRecord = PageRequest.of(1, 2);
      
      List<Course> courseWithPagination = courseRepository.findAll(firstPageWithThreeRecord).getContent();
      int numberOfElements = courseRepository.findAll(firstPageWithThreeRecord).getNumberOfElements();

    }

    @Test
    void findAllUsingSorting() {

      org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 2, 
      Sort.by("title")
      .descending()
      .and(Sort.by("credit")));
      List<Course> sortedCourse = courseRepository.findAll(pageable).getContent();

    }

    @Test
    void findByTitle() {
      org.springframework.data.domain.Pageable pageBasedOnTitle = PageRequest.of(0, 1);
      courseRepository.findPageByTitle("DSA", pageBasedOnTitle).getContent();
    }

    @Test
    void should_save_teacher_student_with_course() {
      Course course = Course.builder().title("Kakfa").credit(8).teacher(createTeacher()).build();
      Student student = createStudent();
      course.addStudent(student);
      courseRepository.save(course);

    }

    private Student createStudent() {
     return Student.builder()
                .firstName("Akash")
                .lastName("goyal")
                .email("akashgoyal@gmail.com")
                .build();
    }

    private Teacher createTeacher() {
      return Teacher.builder()
      .firstName("Jyoti")
      .lastName("Singh")
      .build();
    }
}
