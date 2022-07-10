package com.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequestDto {
    @NotNull
    private String accessToken;
    @NotNull
    private String refreshToken;
}