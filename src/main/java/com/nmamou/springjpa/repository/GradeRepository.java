package com.nmamou.springjpa.repository;


import org.springframework.data.repository.CrudRepository;

import com.nmamou.springjpa.entity.Grade;



public interface GradeRepository extends CrudRepository<Grade, Long> {  
}
