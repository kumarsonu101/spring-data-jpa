package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material", sequenceName = "course_material", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material")
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(name = "course_Id", referencedColumnName = "courseId")
    private Course course;

    public CourseMaterial() {
    }

    public CourseMaterial(Long courseMaterialId, String url, Course course) {
        this.courseMaterialId = courseMaterialId;
        this.url = url;
        this.course = course;
    }

    public Long getCourseMaterialId() {
        return courseMaterialId;
    }

    public void setCourseMaterialId(Long courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    
}
