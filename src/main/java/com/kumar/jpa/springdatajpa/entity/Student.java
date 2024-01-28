package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "student")
@Table(name = "tbl_student",
uniqueConstraints = @UniqueConstraint(name = "emailContstraint", columnNames = "email"))
public class Student {
    
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;
    private String guardianName;
    private String gurdianEmail;
    private String guardianMobile;

    public Student() {

    
    }
    
    public Student(Long studentId, String firstName, String lastName, String email, String guardianName,
            String gurdianEmail, String guardianMobile) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.guardianName = guardianName;
        this.gurdianEmail = gurdianEmail;
        this.guardianMobile = guardianMobile;
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
    public String getGuardianName() {
        return guardianName;
    }
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
    public String getGurdianEmail() {
        return gurdianEmail;
    }
    public void setGurdianEmail(String gurdianEmail) {
        this.gurdianEmail = gurdianEmail;
    }
    public String getGuardianMobile() {
        return guardianMobile;
    }
    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }

    public static class Builder {
        private Student student = new Student();

        private Builder() {

        }

        public Builder id(Long studentId) {
            student.studentId = studentId;
            return this;
        }

        public Builder username(String firstName) {
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


        public Builder guardianName(String guardianName) {
            student.guardianName = guardianName;
            return this;
        }

        public Builder gurdianEmail(String gurdianEmail) {
            student.gurdianEmail = gurdianEmail;
            return this;
        }

        public Builder guardianMobile(String guardianMobile) {
            student.guardianMobile = guardianMobile;
            return this;
        }

        // Add more builder methods for other fields...

        public Student build() {
            // Validate if necessary and return the built User object
            return student;
        }
    }

    }