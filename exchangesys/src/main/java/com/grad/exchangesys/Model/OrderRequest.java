package com.grad.exchangesys.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity @Data
public class OrderRequest {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String serviceNmae;
    private String formN;
    private String ToN;
    private Long IdFrom;
    private Long  IdTo;
    private Boolean is_offer;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_user")
    private User user;


}
