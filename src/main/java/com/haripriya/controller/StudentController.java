package com.haripriya.controller;

import com.haripriya.model.Student;
import com.haripriya.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//marking class as Controller
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentService.displayStudentById(id);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return this.studentService.displayStudents();
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
            this.studentService.deleteStudent(id);
            return "Student details with id "+id+" deleted successfully";
    }
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        return "Student Details added with"+ this.studentService.insertStudent(student);
    }
    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        if(this.studentService.updateStudent(student)==null)
            return "Student not found with Id: "+student.getId()+" to update details";
        return "Student Details Updated with"+ this.studentService.updateStudent(student);
    }

}
