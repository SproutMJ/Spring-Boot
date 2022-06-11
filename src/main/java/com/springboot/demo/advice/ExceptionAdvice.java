package com.springboot.demo.advice;

import com.springboot.demo.config.exception.LoginFailureException;
import com.springboot.demo.config.exception.MemberNicknameAlreadyExistsException;
import com.springboot.demo.config.exception.MemberNotFoundException;
import com.springboot.demo.config.exception.MemberUsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.relation.RoleNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {
    // 500 에러
    @ExceptionHandler(IllegalArgumentException.class) // 지정한 예외가 발생하면 해당 메소드 실행
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 각 예외마다 상태 코드 지정
    public void illegalArgumentExceptionAdvice(IllegalArgumentException e) {
    }

    // 400 에러
    // 요청 객체의 validation을 수행할 때, MethodArgumentNotValidException이 발생
    // 각 검증 어노테이션 별로 지정해놨던 메시지를 응답
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void methodArgumentNotValidException(MethodArgumentNotValidException e) { // 2
    }


    // 401 응답
    // 아이디 혹은 비밀번호 오류시
    @ExceptionHandler(LoginFailureException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void loginFailureException() {
    }

    // 409 응답
    // username 중복
    @ExceptionHandler(MemberUsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void memberEmailAlreadyExistsException(MemberUsernameAlreadyExistsException e) {
    }

    // 409 응답
    // nickname 중복
    @ExceptionHandler(MemberNicknameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void memberNicknameAlreadyExistsException(MemberNicknameAlreadyExistsException e) {
    }


    // 404 응답
    // 요청한 자원을 찾을 수 없음
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void memberNotFoundException() {
    }


    // 404 응답
    // 요청한 자원을 찾을 수 없음
    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void roleNotFoundException() {
    }
}
