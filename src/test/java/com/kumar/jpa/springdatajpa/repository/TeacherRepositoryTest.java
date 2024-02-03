package com.kumar.jpa.springdatajpa.repository;

import static org.mockito.ArgumentMatchers.notNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kumar.jpa.springdatajpa.entity.Course;
import com.kumar.jpa.springdatajpa.entity.Teacher;

import lombok.Builder;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void should_save_teacher_course_data_given_course_details() {

        Teacher teacher = Teacher.builder()
                .firstName("Leena")
                .lastName("Kholi")
              //  .course(addCourseDetails())
                .build();
        if (null != teacher) {
            teacherRepository.save(teacher);
        }

    }

    private List<Course> addCourseDetails() {
        List<Course> coursesList = new ArrayList();
        Course algoCourse = Course.builder()
                .title("Alogrithm")
                .credit(8)
                .build();

        Course devOpCourse = Course.builder()
                .title("DevOps")
                .credit(8)
                .build();

        coursesList.add(algoCourse);
        coursesList.add(devOpCourse);

        return coursesList;
    }
}
