package com.springboot.demo.dto;

import com.springboot.demo.domain.mamber.Member;
import lombok.*;

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
    private String token;

    private Long id;

    String name;

    String username;

    String password;

    public Member toEntity(){
        return null;
    }
}
