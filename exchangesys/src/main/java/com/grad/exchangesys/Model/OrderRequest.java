package com.grad.exchangesys.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity @Data @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_services")
    private ServiceModel  serviceModel;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_provider")
    private User provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_customer")
    private User customer;

    private Boolean isaccept;




}
