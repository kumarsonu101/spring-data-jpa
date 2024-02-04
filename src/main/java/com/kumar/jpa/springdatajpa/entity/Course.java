package com.kumar.jpa.springdatajpa.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.ToString;

@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", allocationSize = 1, sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course",  cascade = CascadeType.ALL)
    private  CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course_map",
        joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))
    private List<Student> students = new ArrayList<>();

   
    public void addStudent(Student student) {
        if(null == student) {
           Collections.emptyList();
        }  
        students.add(student);
    }

    public Course() {
    }

    


    public Course(Long courseId, String title, Integer credit, CourseMaterial courseMaterial, Teacher teacher,
            List<Student> students) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
        this.courseMaterial = courseMaterial;
        this.teacher = teacher;
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Course course = new Course();

        private Builder() {

        }

        public Builder courseId(Long courseId) {
            course.courseId = courseId;
            return this;
        }

        public Builder title(String title) {
            course.title = title;
            return this;
        }

        public Builder credit(Integer credit) {
            course.credit = credit;
            return this;
        }

        public Builder courseMaterial(CourseMaterial courseMaterial) {
            course.courseMaterial = courseMaterial;
            return this;
        }

        public Builder teacher(Teacher teacher) {
            course.teacher = teacher;
            return this;
        }

        // Add more builder methods for other fields...

        public Course build() {
            // Validate if necessary and return the built User object
            return course;
        }

    }

    public CourseMaterial getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(CourseMaterial courseMaterial) {
        this.courseMaterial = courseMaterial;
    }


    public Teacher getTeacher() {
        return teacher;
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
