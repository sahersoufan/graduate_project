package com.grad.exchangesys.chat.model;

import com.grad.exchangesys.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
public class ChatNotification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "senderId")
    private User user;

}
