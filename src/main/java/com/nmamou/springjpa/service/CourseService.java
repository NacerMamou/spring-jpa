package com.nmamou.springjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Course;


@Service
public interface CourseService {
    Course  getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}