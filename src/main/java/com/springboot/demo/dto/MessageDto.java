package com.springboot.demo.dto;

import com.springboot.demo.domain.board.sendtype.SendType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private MemberDto sender;
    private MemberDto receiver;
    private String title;
    private String text;
}
