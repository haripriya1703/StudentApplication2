package com.haripriya.service;

import com.haripriya.exceptions.NoStudentDetailsFoundException;
import com.haripriya.exceptions.StudentNotFoundException;
import com.haripriya.model.Student;
import com.haripriya.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student displayStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException());
    }

    public List<Student> displayStudents(){
        LinkedList<Student> studentsList = new LinkedList<>();
        studentRepository.findAll().forEach(student -> studentsList.add(student));
        if(studentsList.isEmpty())
            throw new NoStudentDetailsFoundException();
        return studentsList;
    }

    public int deleteStudent(int id){
        if(!this.studentRepository.findById(id).isPresent())
            throw new StudentNotFoundException();
        this.studentRepository.deleteById(id);
        return id;
    }

    public Student insertStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        if (this.studentRepository.findById(student.getId()).isPresent()) {
            studentRepository.save(student);
            return student;
        }
        else
            return null;
    }
}
