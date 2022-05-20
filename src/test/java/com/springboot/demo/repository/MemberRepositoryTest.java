package com.springboot.demo.repository;

import com.springboot.demo.domain.Member;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void insertTest() {
        Long beforeSize = memberRepository.count();
        Member member = Member.builder().build();
        memberRepository.save(member);
        Long afterSize = memberRepository.count();
        assertThat(beforeSize + 1).isEqualTo(afterSize);
    }
}