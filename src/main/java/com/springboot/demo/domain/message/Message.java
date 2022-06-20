package com.springboot.demo.domain.message;

import com.springboot.demo.domain.board.sendtype.SendType;
import com.springboot.demo.domain.member.Member;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Builder
@Data
@Entity
@Table
public class Message {
    @Id
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column
    private String title;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member sender;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member receiver;

    public Message() {

    }

    /*public void setMember(Member member){
        this.member = member;

        if(!member.getMessages().contains(member))
            member.getMessages().add(this);
    }*/
}
