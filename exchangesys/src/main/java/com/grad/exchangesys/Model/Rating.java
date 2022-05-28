package com.grad.exchangesys.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
public class Rating {


    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String serviceNmae;
    private String  rate;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @OneToOne
    @JoinColumn(name = "id_order")
    private Orders order;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_user")
    private User user;

}
