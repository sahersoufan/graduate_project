package com.grad.exchangesys.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkLog {

    @Id @GeneratedValue(strategy = AUTO)
   private Long id;
   private String name;
   private String company;


   private String location;
   @CreatedDate
   @JsonFormat(pattern="yyyy-MM-dd")
   private Date startdate;
   @CreatedDate
   @JsonFormat(pattern="yyyy-MM-dd")
   private Date enddate;

//   @OneToMany(cascade = CascadeType.ALL)
//   private List<WorkImage> image;


   @GeneratedValue(strategy = AUTO)
   @ManyToOne
   @JoinColumn(name="id_user")
   private User user;







}
