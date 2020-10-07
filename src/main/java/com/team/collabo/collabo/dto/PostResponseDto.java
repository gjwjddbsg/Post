package com.team.collabo.collabo.dto;

import com.team.collabo.collabo.domain.Comment;
import com.team.collabo.collabo.domain.Post;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostResponseDto {

    private String title;
    private String content;
    private String author;
    private List<CommentResponseDto> comments = new ArrayList<>();

    @Builder
    public PostResponseDto(String title, String content, String author, List<CommentResponseDto> comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }

    public static PostResponseDto toModelMapper(Post post) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .comments(
                        post.getComments().stream().map(comment -> {
                            return CommentResponseDto.toModelMapper(comment);
                        }).collect(Collectors.toList())
                )
                .build();
    }

}
