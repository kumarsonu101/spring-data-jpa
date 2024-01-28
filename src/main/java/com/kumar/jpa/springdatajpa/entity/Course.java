package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", allocationSize = 1, sequenceName = "course_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence" )
    private Long courseId;
    private String title;
    private Integer credit;

    public Course() {
    }
    
    public Course(Long courseId, String title, Integer credit) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
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

    
    
}
