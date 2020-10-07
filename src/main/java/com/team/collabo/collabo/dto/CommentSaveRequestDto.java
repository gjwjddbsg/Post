package com.team.collabo.collabo.dto;

import com.team.collabo.collabo.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    private String content;
    private String author;

    @Builder
    public CommentSaveRequestDto(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .author(author)
                .build();
    }
}
