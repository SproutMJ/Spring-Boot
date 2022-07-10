package com.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author  https://github.com/sosow0212
 * @exception
 * @param accessToken
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@Data
@AllArgsConstructor
public class SignInResponseDto {
    @NotNull
    private String accessToken;
}