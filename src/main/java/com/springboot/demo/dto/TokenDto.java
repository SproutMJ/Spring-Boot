package com.springboot.demo.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author  https://github.com/sosow0212
 * @exception
 * @param grantType
 * @param accessToken
 * @param refreshToken
 * @param accessTokenExpiresIn
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {

    @NotNull
    private String grantType;
    @NotNull
    private String accessToken;
    @NotNull
    private String refreshToken;
    @NotNull
    private Long accessTokenExpiresIn;

    public TokenDto(String access, String refresh) {
        this.accessToken = access;
        this.refreshToken = refresh;
    }
}