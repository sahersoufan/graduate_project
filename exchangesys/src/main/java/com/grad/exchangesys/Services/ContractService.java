package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> get_My_Contracts(Long userId);
    Contract newContract(Contract contract);
    Contract ShowContract_details(Long contractId);
    Boolean deleteContract(Long contract_Serial_Number);


}
