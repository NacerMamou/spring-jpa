package com.nmamou.springjpa.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "score", nullable = false)
    private String score;

}
