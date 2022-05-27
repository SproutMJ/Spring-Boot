package com.springboot.demo.repository;

import com.springboot.demo.domain.Member;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void createDummyUser(){
        Member member = Member.builder().name("dummy").userId("dummy").password("dummy123").build();
        memberRepository.save(member);
    }

    @AfterEach
    void deleteAllMember() {
        memberRepository.deleteAll();
    }

    @Test
    void createTest() {
        Long beforeSize = memberRepository.count();
        Member member = Member.builder().build();
        memberRepository.save(member);
        Long afterSize = memberRepository.count();
        assertThat(beforeSize + 1).isEqualTo(afterSize);
    }

    @Test
    void retrieveTest() {
        Member member = Member.builder().name("hong").userId("test").password("test").build();
        memberRepository.save(member);

        Member findMember = memberRepository.findByUserIdAndPassword("test", "test");
        assertThat(findMember.getUserId()).isEqualTo("test");
    }

    @Test
    void updateTest() {
        Member findMember = memberRepository.findByUserIdAndPassword("dummy", "dummy123");
        assertThat(findMember.getUserId()).isEqualTo("dummy");

        findMember.setName("new name");
        Member updateMember = memberRepository.findByUserIdAndPassword("dummy", "dummy123");
        assertThat(findMember.getName()).isEqualTo("new name");
    }

    @Test
    void deleteTest() {
        Long beforeSize = memberRepository.count();
        Member findMember = memberRepository.findByUserIdAndPassword("dummy", "dummy123");
        memberRepository.delete(findMember);
        Long afterSize = memberRepository.count();
        assertThat(beforeSize - 1).isEqualTo(afterSize);
    }


}