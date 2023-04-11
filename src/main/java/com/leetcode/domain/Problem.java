package com.leetcode.domain;

import com.leetcode.enums.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Problem extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String description;

    private Difficulty difficulty;

    private int likes;

    private int dislikes;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "solvedProblemss")
    private Set<User> solvedBy = new HashSet<>();
//    private double acceptance;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private Set<Submission> submissions = new HashSet<>();


}