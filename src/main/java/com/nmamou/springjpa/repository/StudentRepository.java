package com.nmamou.springjpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nmamou.springjpa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
  
}
