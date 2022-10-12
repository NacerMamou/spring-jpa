package com.nmamou.springjpa.service;

import java.util.List;

import com.nmamou.springjpa.entity.Student;


public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}