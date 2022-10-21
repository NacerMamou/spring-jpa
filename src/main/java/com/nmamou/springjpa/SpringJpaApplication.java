package com.nmamou.springjpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nmamou.springjpa.entity.Course;
import com.nmamou.springjpa.entity.Grade;
import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.repository.CourseRepository;
import com.nmamou.springjpa.repository.GradeRepository;
import com.nmamou.springjpa.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	// @Autowired
	StudentRepository studentRepository;

	// @Autowired
	GradeRepository gradeRepository;

	// @Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
				new Student("Harry Potter", LocalDate.parse("1980-07-31")),
				new Student("Harry Winston", LocalDate.parse("1981-07-31")),
				new Student("Harry Churchil", LocalDate.parse("1982-07-31")),
				new Student("Harry Bloom", LocalDate.parse("1983-07-31")),
				new Student("Harry JMG", LocalDate.parse("1984-07-31")),
		};

		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}

		Course[] courses = new Course[] {
				new Course("Charms", "CH104",
						"In this class, you will learn spells concerned with giving an object new and unexpected properties."),
				new Course("Defence Against the Dark Arts", "DADA",
						"In this class, you will learn defensive techniques against the dark arts."),
				new Course("Herbology", "HB311",
						"In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
				new Course("History of Magic", "HIS393",
						"In this class, you will learn about significant events in wizarding history."),
				new Course("Potions", "POT102",
						"In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
				new Course("Transfiguration", "TR442",
						"In this class, you will learn the art of changing the form or appearance of an object.")
		};

		for (int i = 0; i < courses.length; i++) {
			courseRepository.save(courses[i]);
		}

		Grade[] grades = new Grade[] {
				new Grade(1L, "A+", students[0], courses[0]),
				new Grade(2L, "B+", students[0], courses[1]),
				new Grade(3L, "C+", students[0], courses[2])
		};

		for (int i = 0; i < grades.length; i++) {
			gradeRepository.save(grades[i]);
		}

		

	}

}
