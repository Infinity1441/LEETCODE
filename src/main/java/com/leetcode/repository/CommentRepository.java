package com.leetcode.repository;

import com.leetcode.domain.Category;
import com.leetcode.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
