package com.nmamou.springjpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Course;
import com.nmamou.springjpa.entity.Grade;
import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.exceptions.GradeNotFoundException;
import com.nmamou.springjpa.repository.CourseRepository;
import com.nmamou.springjpa.repository.GradeRepository;
import com.nmamou.springjpa.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

	StudentRepository studentRepository;

	GradeRepository gradeRepository;

	CourseRepository courseRepository;

	@Override
	public Grade getGrade(Long studentId, Long courseId) {
		Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		if (grade.isPresent()){
			System.out.print("present: "); System.out.print(grade.isPresent());System.out.print("Content : "); System.out.print(grade.get());
			return grade.get();
		}
		else{
			throw new GradeNotFoundException(studentId, courseId);
		}
	}

	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
		Student student = studentRepository.findById(studentId).get();
		grade.setStudent(student);
		Course course = courseRepository.findById(courseId).get();
		grade.setCourse(course);
		return gradeRepository.save(grade);
	}

	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		
		Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		if (grade.isPresent()) {
			Grade unwrappedGrade = grade.get();
			unwrappedGrade.setScore(score);
			return gradeRepository.save(unwrappedGrade);
		} 
		else {
			System.out.print("Error while trying to update the grade fingerprint");
			throw new GradeNotFoundException(studentId, courseId);
		}
	}

	@Override
	public void deleteGrade(Long studentId, Long courseId) {
		gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
	}

	@Override
	public List<Grade> getStudentGrades(Long studentId) {
		return gradeRepository.findByStudentId(studentId);
	}

	@Override
	public List<Grade> getCourseGrades(Long courseId) {
		return gradeRepository.findByCourseId(courseId);
	}

	@Override
	public List<Grade> getAllGrades() {
		return (List<Grade>) gradeRepository.findAll();
	}

}
