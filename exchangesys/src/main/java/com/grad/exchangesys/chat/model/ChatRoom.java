package com.grad.exchangesys.chat.model;

import javax.persistence.*;

import com.grad.exchangesys.Model.User;
import lombok.Builder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String chatId;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "senderId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "recipientId")
    private User user1;
    
}