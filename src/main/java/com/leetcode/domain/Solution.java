package com.leetcode.domain;

import com.leetcode.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Solution extends Auditable{
    @Id
    @UuidGenerator
    private String id;

    private String title;

    private Language language;

    private String code;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();


}