package com.springboot.demo.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardDto {
    @NotNull
    private String title;
    @NotNull
    private String text;
    private Long like;
}
