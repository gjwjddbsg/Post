package com.team.collabo.collabo.domain;

import com.team.collabo.collabo.dto.PostUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_author")
    private String author;

    @Builder
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post updatePost(PostUpdateRequestDto updateRequestDto) {
        this.title = updateRequestDto.getNewTitle();
        this.content = updateRequestDto.getNewContent();
        this.author = updateRequestDto.getNewAuthor();

        return this;
    }

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }


}
