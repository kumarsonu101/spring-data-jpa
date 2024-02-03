package com.kumar.jpa.springdatajpa.entity;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    
    public Course() {
    }


    public Course(Long courseId, String title, Integer credit, Teacher teacher, CourseMaterial courseMaterial) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
        this.courseMaterial = courseMaterial;
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
