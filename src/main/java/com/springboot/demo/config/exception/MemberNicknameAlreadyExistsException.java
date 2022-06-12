package com.springboot.demo.config.exception;


/**
 * @author  https://github.com/sosow0212
 * @exception MemberNicknameAlreadyExistsException
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
public class MemberNicknameAlreadyExistsException extends RuntimeException{
    public MemberNicknameAlreadyExistsException(String message) {
        super(message);
    }
}
