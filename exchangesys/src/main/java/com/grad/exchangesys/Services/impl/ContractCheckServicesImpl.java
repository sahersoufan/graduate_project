package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Contract;
import com.grad.exchangesys.Repository.ContractRepo;
import com.grad.exchangesys.Services.ContractCheckServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractCheckServicesImpl implements ContractCheckServices {

    private final ContractRepo contractRepo;

    @Override
    public Boolean check_if_existed(Contract contract) {
        for (Contract c :contractRepo.findAll()){
            if(c.getContract_Serial_Number()==contract.getContract_Serial_Number()){
                return true;
            }
        }
        return false;
    }


    @Override
    public Boolean check_if_contract_istrue(Contract contract ) {
        for (Contract c :contractRepo.findAll()){
            if(c.is_equl(contract)){
                return true;
            }
        }
      return false;
    }

    @Override
    public Boolean check_and_replace(Contract contract) {


        if(check_if_contract_istrue(contract)){
            System.out.println("the contract is existed and true  " );
            return true;
        }
        if(!check_if_contract_istrue(contract)){
            System.out.println("the contract is existed and not a true contract  \n the contract was edited form som one " );
            return false;
        }
        return false;
    }
}
