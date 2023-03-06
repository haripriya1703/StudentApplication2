package com.haripriya;

import com.haripriya.controller.StudentController;
import com.haripriya.model.Student;
import com.haripriya.repository.StudentRepository;
import com.haripriya.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class StudentAppApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentController studentController;
//	private AutoCloseable closeable;
//	 private Student student=new Student("Priya",123);
//	@BeforeEach
//	void initService() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@AfterEach
//	void closeService() throws Exception {
//		closeable.close();
//	}
//	@Test
//	void getNameTest(){
//		Mockito.when(student.getName()).thenReturn("Priya");
//	}
}
