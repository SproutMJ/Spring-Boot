package com.springboot.demo.dto;

import lombok.*;

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

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}