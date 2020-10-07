package com.team.collabo.collabo.repository;

import com.team.collabo.collabo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
