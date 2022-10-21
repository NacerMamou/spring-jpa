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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor

@Table(name = "grade", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "student_id", "course_id" })
})
public class Grade {
	// Constraints added to prevent associating multiple grades for the same student
	// id coupled with same course id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "score", nullable = false)
	private String score;

	// If optional is not set to false the grade will be registred even if the
	// student_id is not specified
	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

}
