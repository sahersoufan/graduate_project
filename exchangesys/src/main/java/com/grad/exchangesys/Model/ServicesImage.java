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
public class ServicesImage {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String imagePath;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne
    @JoinColumn(name="id_services")
    private ServiceModel serviceModel;
}
