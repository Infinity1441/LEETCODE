package com.leetcode.repository;

import com.leetcode.domain.Comment;
import com.leetcode.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
}
