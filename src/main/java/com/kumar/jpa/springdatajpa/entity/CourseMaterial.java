package com.kumar.jpa.springdatajpa.entity;

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
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(
        fetch = FetchType.EAGER,
        optional = false
    )
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
     @ManyToOne(cascade = CascadeType.PERSIST)
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

    public static Builder builder() {
        return new Builder();
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
