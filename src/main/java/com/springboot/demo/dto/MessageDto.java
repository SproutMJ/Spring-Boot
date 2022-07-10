package com.springboot.demo.dto;

import com.springboot.demo.domain.board.sendtype.SendType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author  https://github.com/SproutMJ
 * @exception
 * @param
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "메시지 보내기")
public class MessageDto {
    @NotNull
    private MemberDto sender;
    @NotNull
    private MemberDto receiver;
    @NotNull
    private String title;
    @NotNull
    private String text;
}
