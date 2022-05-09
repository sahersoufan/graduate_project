package com.grad.exchangesys.Model;


import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Map;

import static javax.persistence.GenerationType.AUTO;

@Entity
@EnableAutoConfiguration
@Data
@AllArgsConstructor
@Setter
@Getter
public class FriendsList {



    @Id
    private Long id_user;

    private String name;

    private Long id_friend;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_freinds")
    private User user;
    //     private  Map<Long,String> friends;
    public FriendsList()
    {
//        this.friends.put(user.getId(),user.getUsername());
        //->   if(this.id!=null)
//        this.friends.put(this.id_friend,this.name);

    }

}
