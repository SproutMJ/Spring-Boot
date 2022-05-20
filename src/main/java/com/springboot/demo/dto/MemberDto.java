package com.springboot.demo.dto;

import com.springboot.demo.domain.Member;
import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
    private String token;

    private Long id;

    String name;

    String userId;

    String password;

    public Member toEntity(){
        return null;
    }
}
