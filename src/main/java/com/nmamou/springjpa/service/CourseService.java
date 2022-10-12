package com.nmamou.springjpa.service;

import java.util.List;

import com.nmamou.springjpa.entity.Course;


public interface CourseService {
    Course  getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}