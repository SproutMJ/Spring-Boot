package com.springboot.demo.dto;

import com.springboot.demo.domain.mamber.Member;
import com.springboot.demo.domain.mamber.auth.Authority;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

/**
 * @author  https://github.com/sosow0212
 * @exception
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "로그인 요청")
public class LoginRequestDto {

    @ApiModelProperty(value = "아이디", notes = "아이디를 입력해주세요", required = true, example = "sosow0212")
    @NotBlank(message = "{LoginRequestDto.username.notBlank}")
    private String username;

    @ApiModelProperty(value = "비밀번호", required = true, example = "123456")
    @NotBlank(message = "{LoginRequestDto.password.notBlank}")
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

}