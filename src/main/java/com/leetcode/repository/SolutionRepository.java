package com.leetcode.repository;

import com.leetcode.domain.Comment;
import com.leetcode.domain.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}
