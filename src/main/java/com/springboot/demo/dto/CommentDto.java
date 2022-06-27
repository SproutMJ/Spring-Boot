package com.springboot.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentDto {
    private String comment;
    private String author;
}
