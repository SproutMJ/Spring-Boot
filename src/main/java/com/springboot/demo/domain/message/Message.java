package com.springboot.demo.domain.message;

import com.springboot.demo.domain.member.Member;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Getter
@AllArgsConstructor
@Builder
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

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "SENDER_ID")
    private Member sender;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne
    @JoinColumn(name = "RECEIVER_ID")
    private Member receiver;

    public Message() {

    }

    /*public void setMember(Member member){
        this.member = member;

        if(!member.getMessages().contains(member))
            member.getMessages().add(this);
    }*/
}
