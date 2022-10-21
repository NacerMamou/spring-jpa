package com.nmamou.springjpa.repository;

import org.springframework.data.repository.CrudRepository;
import com.nmamou.springjpa.entity.Course;



public interface CourseRepository extends CrudRepository<Course, Long> {
}
