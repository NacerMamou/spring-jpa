package com.nmamou.springjpa.service;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Grade;
import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.exceptions.StudentNotFoundException;
import com.nmamou.springjpa.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return unwrapStudent(student, id);
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	static Student unwrapStudent(Optional<Student> entity, Long id) {
		if (entity.isPresent())
			return entity.get();
		else
			throw new StudentNotFoundException(id);
	}

	public void printGrades(Student student) {
		for (Grade grade : student.getGrades()) {
			System.out.println(grade.getScore());
		}
	}

	

}