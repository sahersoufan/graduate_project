package com.grad.exchangesys.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    private Long user_id;


    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="freinds_id")
    private User user;
}
