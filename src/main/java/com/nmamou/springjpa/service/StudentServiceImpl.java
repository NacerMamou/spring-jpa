package com.nmamou.springjpa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
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
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        System.out.println(students);
        return students;
    }


}