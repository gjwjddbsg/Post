package com.team.collabo.collabo.controller;

import com.team.collabo.collabo.dto.CommentSaveRequestDto;
import com.team.collabo.collabo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{id}")
    public Long register(@PathVariable("id") Long id, @RequestBody CommentSaveRequestDto saveRequestDto) {
        return commentService.saveComment(id, saveRequestDto);
    }
}
