package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "student")
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "emailContstraint", columnNames = "email"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;

    @Embedded
    Guardian guardian;

    public Student() {

    }

    public Student(Long studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getStudentId() {
        return studentId;
    }


    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Student student = new Student();

        private Builder() {

        }

        public Builder studentId(Long studentId) {
            student.studentId = studentId;
            return this;
        }

        public Builder firstName(String firstName) {
            student.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            student.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            student.email = email;
            return this;
        }
        public Builder guardian(Guardian guardian) {
            student.guardian = guardian;
            return this;
        }
        // Add more builder methods for other fields...

        public Student build() {
            // Validate if necessary and return the built User object
            return student;
        }
    }

}