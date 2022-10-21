package com.nmamou.springjpa.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.nmamou.springjpa.entity.Grade;



public interface GradeRepository extends CrudRepository<Grade, Long> {  
  // Querying a grabe by its student id
  // Can define a new abstract Method to for custom querry
  // FindBy+CamelCase atribute
  // The method will be overrided by spring jpa and implementation will be created 
  // To pick up a grade by its student id
  
  
  List<Grade> findByStudentId(Long studentId);
  List<Grade> findByCourseId(Long courseId);
  Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId );
  
  // Specify for delete operations
  @Transactional
  void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
  // findBy + StudentId + And + CourseId

}
