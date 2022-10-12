package com.nmamou.springjpa.service;

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
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {        
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }


}