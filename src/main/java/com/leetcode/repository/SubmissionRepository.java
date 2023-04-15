package com.leetcode.repository;

import com.leetcode.domain.Comment;
import com.leetcode.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
}
