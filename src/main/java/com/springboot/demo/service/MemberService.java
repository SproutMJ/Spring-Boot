package com.springboot.demo.service;

import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.Member;
import com.springboot.demo.dto.MemberDto;
import com.springboot.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

@Transactional
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

    public Optional<Member> find(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void updateUser(Long id, MemberDto updateMemberInfoDto) {
        Optional<Member> beforeInfo = memberRepository.findById(id);
        beforeInfo.get().setName(updateMemberInfoDto.getName());
        beforeInfo.get().setUsername(updateMemberInfoDto.getUsername());
        beforeInfo.get().setNickName(updateMemberInfoDto.getNickName());
        beforeInfo.get().setPassword(updateMemberInfoDto.getPassword());
    }

    public void deleteUser(Long id) {
        memberRepository.delete(memberRepository.findById(id).get());
    }

    public List<Board> findUserFavorites(long id) {
        return null;
    }
}
