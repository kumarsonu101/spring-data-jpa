package com.kumar.jpa.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "student")
public class Student {
    
    @Id
    @GeneratedValue()
    private Long studentId;
    private String firstName;
    private String lastName;
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

    
}
