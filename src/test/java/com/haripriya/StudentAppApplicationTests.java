package com.haripriya;

import com.haripriya.model.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.haripriya.repository.StudentRepository;
import com.haripriya.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class StudentAppApplicationTests {

    @MockBean
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    @Test
    void displayStudentsTest() {
        when(studentRepository.findAll()).thenReturn(Stream.of(new Student(1,"test", 123),
                new Student(2,"test2", 1235)).collect(Collectors.toList()));
        assertEquals(2, studentService.displayStudents().size());
    }

    @Test
    void insertStudentTest(){
        Student student= new Student(1,"test 3",12345);
        when(studentRepository.save(student)).thenReturn(student);
        assertEquals(student,studentService.insertStudent(student));
    }

    @Test
    void displayStudentById(){
        Student student= new Student(1,"test", 123);
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        assertEquals(student,studentService.displayStudentById(1));
    }

   @Test
    void updateStudentTest(){
       Student student= new Student(1,"test 3",12345);
       when(studentRepository.save(student)).thenReturn(student);
       student.setStudentName("test 4");
       when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
       studentService.updateStudent(student);
       verify(studentRepository).save(student);
       verify(studentRepository).findById(student.getId());
   }

   @Test
    void deleteStudent(){
       Student student= new Student();
       student.setId(1);
       student.setStudentName("hari");
       student.setContactNumber(768);
       when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
       studentService.deleteStudent(student.getId());
       verify(studentRepository).deleteById(student.getId());
   }

}
