package com.grad.exchangesys.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
public class Comments {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Orders order;


    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_user")
    private User user;

}


