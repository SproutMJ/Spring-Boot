package com.springboot.demo.domain.message;

import com.springboot.demo.domain.board.sendtype.SendType;
import com.springboot.demo.domain.member.Member;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table
public class Message {
    @Id
    @Column(name = "MESSAGE_ID")
    Long id;

    @Column
    String title;

    @Column
    String text;

    @Enumerated(EnumType.STRING)
    SendType sendType;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    public void setMember(Member member){
        this.member = member;

        if(!member.getMessages().contains(member))
            member.getMessages().add(this);
    }
}
