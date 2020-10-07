package com.team.collabo.collabo.dto;

import com.team.collabo.collabo.domain.Comment;
import com.team.collabo.collabo.domain.Post;
import lombok.Builder;

import java.util.List;

public class CommentResponseDto {

    private String content;
    private String author;

    @Builder
    public CommentResponseDto(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public static CommentResponseDto toModelMapper(Comment comment) {
        return CommentResponseDto.builder()
                .content(comment.getContent())
                .author(comment.getAuthor())
                .build();
    }

}
