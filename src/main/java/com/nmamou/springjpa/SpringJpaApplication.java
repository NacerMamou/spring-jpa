package com.nmamou.springjpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Student[] students = new Student[]{
			new Student(1L, "Harry Potter", LocalDate.parse("1980-07-31")),
			new Student(2L, "Harry Winston", LocalDate.parse("1981-07-31")),
			new Student(3L, "Harry Churchil", LocalDate.parse("1982-07-31")),
			new Student(4L, "Harry Bloom", LocalDate.parse("1983-07-31")),
			new Student(5L, "Harry JMG", LocalDate.parse("1984-07-31")),
		};
		
		for(int i=0; i<students.length; i++){
			studentRepository.save(students[i]);
		}
	}

}
