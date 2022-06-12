package com.springboot.demo.config.exception;


/**
 * @author  https://github.com/sosow0212
 * @exception MemberUsernameAlreadyExistsException
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
public class MemberUsernameAlreadyExistsException extends RuntimeException{
    public MemberUsernameAlreadyExistsException(String message) {
        super(message);
    }
}
