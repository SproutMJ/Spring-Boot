package com.springboot.demo.service;

import com.springboot.demo.domain.Member;
import com.springboot.demo.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member create(final Member member){
        if(member == null) throw new RuntimeException();
        return memberRepository.save(member);
    }

    public Member find(String loginId, String password){
        return memberRepository.findByUserIdAndPassword(loginId, password);
    }
}
