package com.grad.exchangesys.chat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.grad.exchangesys.Model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
public class ChatMessage implements Serializable {
   private static final long serialVersionUID = 1L;

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

   private String content;
   private Date timestamp;
   @Enumerated(EnumType.STRING)
   private MessageStatus status;


}