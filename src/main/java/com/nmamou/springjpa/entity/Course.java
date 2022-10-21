package com.nmamou.springjpa.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Entity
@Setter
@Getter

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor

@Table(name="course") 
public class Course {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NonNull
  @Column(name = "subject", nullable = false)
  private String subject;
  
  @NonNull
  @Column(name = "code", nullable = false)
  private String code;
  
  @NonNull
  @Column(name = "description", nullable = false)
  private String description;

  // One course havine many grades
  // a grade cannot exist without a course
  @JsonIgnore
  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL )
  private List<Grade> grades;

  
}
