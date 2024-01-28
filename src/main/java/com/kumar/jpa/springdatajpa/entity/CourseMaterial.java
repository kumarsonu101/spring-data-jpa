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

    public static class Builder {
        private CourseMaterial courseMaterial = new CourseMaterial();

        private Builder() {

        }

        public Builder courseMaterialId(Long courseMaterialId) {
            courseMaterial.courseMaterialId = courseMaterialId;
            return this;
        }

        public Builder url(String url) {
            courseMaterial.url = url;
            return this;
        }

    
        public Builder Course(Course course) {
            courseMaterial.course = course;
            return this;
        }
        // Add more builder methods for other fields...

        public CourseMaterial build() {
            // Validate if necessary and return the built User object
            return courseMaterial;
        }
    }


    
}
