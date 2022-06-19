package com.springboot.demo.domain.member;

import com.springboot.demo.domain.board.Board;
import com.springboot.demo.domain.member.auth.Authority;
import com.springboot.demo.domain.message.Message;
import lombok.*;

import javax.persistence.*;
import java.util.List;


/**
 * @author https://github.com/SproutMJ
 * @exception
 * @param name
 * @param nickName
 * @param username
 * @param password
 * @param authority
 * @return
 * @see
 * @serial
 * @serialData
 * @serialField
 * @since
 * @throws
 * @version
 */
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String name;

    @Column
    String nickName;

    @Column(unique = true)
    String username;

    @Column
    String password;

    @JoinColumn

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "member")
    List<Board> boards;

    @OneToMany(mappedBy = "member")
    List<Message> messages;
}
