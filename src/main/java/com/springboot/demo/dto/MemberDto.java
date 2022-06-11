package com.springboot.demo.dto;

import com.springboot.demo.domain.mamber.Member;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
    private String token;

    private Long id;

    String name;

    String username;

    String password;

    public Member toEntity(){
        return null;
    }
}
