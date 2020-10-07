package com.team.collabo.collabo.dto;

import com.team.collabo.collabo.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostUpdateRequestDto {

    private String newTitle;
    private String newContent;
    private String newAuthor;

    @Builder
    public PostUpdateRequestDto(String title, String content, String author) {
        this.newTitle = title;
        this.newContent = content;
        this.newAuthor = author;
    }

    public Post toEntity() {
        return Post.builder()
                .title(newTitle)
                .content(newContent)
                .author(newAuthor)
                .build();
    }
}
