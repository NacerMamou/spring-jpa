package com.nmamou.springjpa.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NonNull
    @Column(name="name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    // One student having many grades
    // a grade cannot exist without a student
    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL )
    private List<Grade> grades;
    
    // One student havine many courses
    // a course cannot exist without a student
    // @JsonIgnore
    // @OneToMany(mappedBy = "student", cascade = CascadeType.ALL )
    // private List<Course> courses;

    // Setters and Getters can be removed after using lombock @Setter and @Getter anotations
    // Can alse use @AllArgsConstructor and @NoArgsConstructor instead of the constructor methods

}
