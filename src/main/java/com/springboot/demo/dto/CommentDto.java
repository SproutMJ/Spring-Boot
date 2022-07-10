package com.springboot.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class CommentDto {
    @NotNull
    private String comment;
    @NotNull
    private String author;
}
