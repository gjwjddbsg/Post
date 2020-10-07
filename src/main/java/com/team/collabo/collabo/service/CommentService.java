package com.team.collabo.collabo.service;

import com.team.collabo.collabo.domain.Comment;
import com.team.collabo.collabo.domain.Post;
import com.team.collabo.collabo.dto.CommentSaveRequestDto;
import com.team.collabo.collabo.repository.CommentRepository;
import com.team.collabo.collabo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long saveComment(Long id, CommentSaveRequestDto saveRequestDto) {
        Post post = postRepository.findById(id).get();

        Comment newComment = saveRequestDto.toEntity();
        System.out.println(newComment.getContent());

        post.addComment(newComment);
        newComment.setTargetPost(post);


        return commentRepository.save(newComment).getId();
    }
}
