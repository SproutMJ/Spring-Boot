package com.springboot.demo.repository;

import com.springboot.demo.domain.mamber.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsernameAndPassword(String username, String password);
    Optional<Member> findByName(String name);
    Optional<Member> findByUsername(String username);
    boolean existsByName(String name);
}
