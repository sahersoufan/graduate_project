package com.grad.exchangesys.Model;


import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Map;

import static javax.persistence.GenerationType.AUTO;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendsList {



    @Id @GeneratedValue(strategy = AUTO)
     private Long id;
    private Long user_id;
    private Long iszone;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="freinds_id")
     private User user;


}
