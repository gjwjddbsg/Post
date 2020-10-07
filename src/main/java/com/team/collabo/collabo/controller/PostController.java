package com.team.collabo.collabo.controller;

import com.team.collabo.collabo.domain.Post;
import com.team.collabo.collabo.dto.PostResponseDto;
import com.team.collabo.collabo.dto.PostSaveRequestDto;
import com.team.collabo.collabo.dto.PostUpdateRequestDto;
import com.team.collabo.collabo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public Long savePost(@RequestBody PostSaveRequestDto saveRequestDto) {
        return postService.savePost(saveRequestDto);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto updateRequestDto) {
        return postService.updatePost(id, updateRequestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
//        System.out.println(postService.findAll());

        return postService.findAll();

    }

}
