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
public class Orders {


    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serviceNmae;


    private String formName;
    private String ToName;

    private Long IdFrom;
    private Long  IdTo;
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_user")
    private User user;

    public Orders convertObject(OrderRequest orderRequest){
        this .setServiceNmae(orderRequest.getServiceNmae());

        this .setFormName(  orderRequest.getFormN());
        this .setToName(orderRequest.getToN());

        this .setIdFrom( orderRequest.getIdFrom());
        this .setIdTo(orderRequest.getIdTo());

        this .setDate(orderRequest.getDate());

        this .setUser(orderRequest.getUser());

        return this;
    }

}
