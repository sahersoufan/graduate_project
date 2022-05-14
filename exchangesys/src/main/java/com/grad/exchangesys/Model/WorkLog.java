package com.grad.exchangesys.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@Entity
@EnableAutoConfiguration
@Data
@AllArgsConstructor
@Setter
@Getter
public class WorkLog {

    @Id @GeneratedValue(strategy = AUTO)
   private Long id;
   private String name;
   private String imagePath;
   private String videoPath;
   private String location;
   private String ratting;

   @GeneratedValue(strategy = AUTO)
   @ManyToOne
   @JoinColumn(name="id_user")
   private User user;







}
