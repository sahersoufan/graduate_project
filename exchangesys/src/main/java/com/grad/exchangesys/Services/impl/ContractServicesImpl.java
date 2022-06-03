package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Contract;
import com.grad.exchangesys.Repository.ContractRepo;
import com.grad.exchangesys.Services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServicesImpl implements ContractService {
       private final ContractRepo contractRepo;

    @Override
    public List<Contract> get_My_Contracts(Long userId) {
        List<Contract> mycontracts = new ArrayList<>();

        for(Contract c : contractRepo.findAll()){
            if(c.getFirstuser().getId()==userId  ||  c.getSeconduser().getId() == userId ){
                mycontracts.add(c);
            }
        }
        return mycontracts;
    }

    @Override
    public Contract newContract(Contract contract) {
            return contractRepo.save(contract);
    }

    @Override
    public Contract ShowContract_details(Long contractId) {
      return contractRepo.getById(contractId);
    }

    @Override
    public Boolean deleteContract(Long contract_Serial_Number) {
        for(Contract c : contractRepo.findAll()){
            if(c.getContract_Serial_Number()==contract_Serial_Number)
                contractRepo.delete(c);
        }
    return true;
    }
}
