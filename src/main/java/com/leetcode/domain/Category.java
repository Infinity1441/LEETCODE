package com.leetcode.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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
    @UuidGenerator
    private String id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Problem> problems;


}