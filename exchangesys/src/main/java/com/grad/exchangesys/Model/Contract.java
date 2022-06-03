package com.grad.exchangesys.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description_Contract;
    private Long contract_Serial_Number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_firstUser")
    private User firstuser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_secondUser")
    private User seconduser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_firstService")
    private ServiceModel firstservice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_secondService")
    private ServiceModel secondservice;

    private String conditionuser1;
    private String conditionuser2;

    private Boolean acceptuser1;
    private Boolean acceptuser2;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;




    public Boolean is_equl(Contract contract){
        if(this.contract_Serial_Number==contract.getContract_Serial_Number())
        if( this.description_Contract.equals(contract.getDescription_Contract()) &&
            this.firstuser== contract.getFirstuser() && this.seconduser== contract.getSeconduser() &&
            this.firstservice == contract.getFirstservice() && this.secondservice == contract.getSecondservice() &&
            this.conditionuser1.equals(contract.getConditionuser1()) && this.conditionuser2.equals(contract.getConditionuser2()) &&
            this.acceptuser1 == contract.acceptuser1 && this.acceptuser2 == contract.getAcceptuser2() &&
            this .startTime ==contract.getStartTime() && this.endTime == contract.getEndTime()  ){
            return true;
        }
        return false;
    }

    public Boolean is_same_contract(Contract contract){
        if(this.contract_Serial_Number == contract.getContract_Serial_Number())
            return true;
        return false;
    }

}
