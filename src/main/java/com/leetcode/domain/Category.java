package com.leetcode.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Problem> problems;

    @Builder(builderMethodName = "childBuilder")
    public Category(Long createdBy, Long updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, Integer id, String name, Set<Problem> problems) {
        super(createdBy, updatedBy, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.problems = problems;
    }
}