package com.leetcode.domain;

import com.leetcode.enums.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Submission extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String code;
    private Language language;
    private boolean correct;
    private double speed;   //speed in milliseconds
    private double memory;  //memory usage in mb
}