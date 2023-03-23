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
                .orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> displayStudents(){
        LinkedList<Student> studentsList = new LinkedList<>(studentRepository.findAll());
        if(studentsList.isEmpty())
            throw new NoStudentDetailsFoundException();
        return studentsList;
    }

    public void deleteStudent(int id){
        if(this.studentRepository.findById(id).isEmpty())
            throw new StudentNotFoundException();
        this.studentRepository.deleteById(id);
    }

    public Student insertStudent(Student student)
    {
        if(student!=null)
            return studentRepository.save(student);
        throw new StudentNotFoundException();
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
