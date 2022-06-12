package com.springboot.demo.service;

import com.springboot.demo.domain.mamber.Member;
import com.springboot.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author https://github.com/SproutMJ
 * @exception
 * @param
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws RuntimeException
 * @version
 */
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(final Member member){
        if(member == null) throw new RuntimeException();
        return memberRepository.save(member);
    }

    public Member find(String loginId, String password){
        return memberRepository.findByUsernameAndPassword(loginId, password);
    }
}
