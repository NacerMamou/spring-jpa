package com.nmamou.springjpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "score", nullable = false)
    private String score;

    // If optional is not set to false the grade will be registred if if the student_id is not specified
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id" ,referencedColumnName = "id")
    private Student student;

}
