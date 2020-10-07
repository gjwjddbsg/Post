package com.team.collabo.collabo.repository;

import com.team.collabo.collabo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
