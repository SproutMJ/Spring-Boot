package com.springboot.demo.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author  https://github.com/sosow0212
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
@Getter
@AllArgsConstructor
public class Failure implements Result{
    private String msg;
}
