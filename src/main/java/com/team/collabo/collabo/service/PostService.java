package com.team.collabo.collabo.service;

import com.team.collabo.collabo.domain.Post;
import com.team.collabo.collabo.dto.CommentResponseDto;
import com.team.collabo.collabo.dto.PostResponseDto;
import com.team.collabo.collabo.dto.PostSaveRequestDto;
import com.team.collabo.collabo.dto.PostUpdateRequestDto;
import com.team.collabo.collabo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long savePost(PostSaveRequestDto saveRequestDto) {
        return postRepository.save(saveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long updatePost(Long id, PostUpdateRequestDto updateRequestDto) {
        Post post = postRepository.findById(id).get();
        post.updatePost(updateRequestDto);
        return post.getId();
    }

    @Transactional
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }

    @Transactional
    public List<Post> findAll() {
        return postRepository.findAll();
//                .stream().map(post -> {
//                    return PostResponseDto.toModelMapper(post);
//                }).collect(Collectors.toList());
    }
}
