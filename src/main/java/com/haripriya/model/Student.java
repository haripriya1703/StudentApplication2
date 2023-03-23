package com.haripriya.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentName;
    private int contactNumber;

    public Student(){}
    //constructor
    public Student(String studentName, int contactNumber) {
        this.studentName = studentName;
        this.contactNumber = contactNumber;
    }

    public Student(int id, String studentName, int contactNumber) {
        super();
        this.id=id;
        this.studentName = studentName;
        this.contactNumber = contactNumber;
    }


    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && contactNumber == student.contactNumber && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, contactNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + studentName + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
