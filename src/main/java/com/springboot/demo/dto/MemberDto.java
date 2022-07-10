package com.springboot.demo.dto;

import com.springboot.demo.domain.member.Member;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author  https://github.com/sosow0212
 * @exception
 * @param token
 * @param name
 * @param username
 * @param password
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
    @NotNull
    private String token;
    @NotNull
    private Long id;
    @NotNull
    String name;
    @NotNull
    String username;
    @NotNull
    String password;
    @NotNull
    String nickName;

    public Member toEntity(){
        return null;
    }
}
