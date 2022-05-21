package com.grad.exchangesys.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkImage {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String imagePath;

    @GeneratedValue(strategy = AUTO)
    @ManyToOne
    @JoinColumn(name="id_work")
    private WorkLog workLog;






}
