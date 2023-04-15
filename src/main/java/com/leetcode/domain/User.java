package com.leetcode.domain;

import com.leetcode.enums.Role;
import com.leetcode.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;

    private String name;
    private String password;

    private String gender;

    private String location;

    private LocalDate birthdate;

    private String github;

    private String linkedin;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Submission> submissions = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_problem",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "problem_id")
    )
    private Set<Problem> solvedProblems = new HashSet<>();

    @Builder(builderMethodName = "childBuilder")
    public User(Long createdBy, Long updateBy,String email, LocalDateTime createdAt, LocalDateTime updatedAt, Integer id, String username, String name, String password, String gender, String location, LocalDate birthdate, String github, String linkedin, Status status, Role role, Set<Submission> submissions, Set<Comment> comments, Set<Problem> solvedProblems) {
        super(createdBy, updateBy, createdAt, updatedAt);
        this.id = id;
        this.email = email;
        this.username = username;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.location = location;
        this.birthdate = birthdate;
        this.github = github;
        this.linkedin = linkedin;
        this.status = status;
        this.role = role;
        this.submissions = submissions;
        this.comments = comments;
        this.solvedProblems = solvedProblems;
    }
}