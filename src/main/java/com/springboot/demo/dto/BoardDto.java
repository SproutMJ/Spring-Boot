package com.springboot.demo.dto;

import lombok.*;
import org.springframework.stereotype.Service;


@Getter
@Builder
public class BoardDto {
    private String title;
    private String text;
    private Long like;
}
