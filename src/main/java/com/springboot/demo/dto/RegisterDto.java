package com.springboot.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author  https://github.com/sosow0212
 * @exception
 * @param username
 * @param password
 * @param name
 * @param nickName
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@ApiModel(value = "회원가입 요청")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @ApiModelProperty(value = "아이디", notes = "아이디를 입력해주세요", required = true, example = "sosow0212")
    @NotBlank(message = "아이디를 입력해주세요.")
    private String username;

    @ApiModelProperty(value = "비밀번호", required = true, example = "123456")
    @NotBlank(message = "비밀번호를 입력해주세요.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "비밀번호는 최소 8자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String password;

    @ApiModelProperty(value = "사용자 이름", notes = "사용자 이름은 한글 또는 알파벳으로 입력해주세요.", required = true, example = "이재윤")
    @NotBlank(message = "사용자 이름을 입력해주세요.")
    @Size(min=2, message = "사용자 이름이 너무 짧습니다.")
    private String name;

    @ApiModelProperty(value = "닉네임", notes = "닉네임은 한글 또는 알파벳으로 입력해주세요.", required = true, example = "고고링")
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min=2, message = "닉네임이 너무 짧습니다.")
    private String nickName;


}
