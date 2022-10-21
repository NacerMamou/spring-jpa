package com.nmamou.springjpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nmamou.springjpa.entity.Course;
import com.nmamou.springjpa.exceptions.CourseNotFoundException;
import com.nmamou.springjpa.repository.CourseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

	CourseRepository courseRepository;

	@Override
	public Course getCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent())
			return course.get();
		else
			throw new CourseNotFoundException(id);
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);

	}

	@Override
	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}

}
