package com.springboot.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author  https://github.com/sosow0212
 * @exception
 * @param accessToken
 * @param refreshToken
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
public class TokenRequestDto {
    private String accessToken;
    private String refreshToken;
}