package com.nmamou.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Grade;
import com.nmamou.springjpa.entity.Student;
import com.nmamou.springjpa.repository.GradeRepository;
import com.nmamou.springjpa.repository.StudentRepository;

@Service
public class GradeServiceImpl implements GradeService {    
    
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GradeRepository gradeRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return null;
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        grade.setStudent(student);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }

}
