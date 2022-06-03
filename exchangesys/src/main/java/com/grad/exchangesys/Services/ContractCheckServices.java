package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.Contract;

public interface ContractCheckServices {
     Boolean check_if_existed(Contract contract);
     Boolean check_if_contract_istrue(Contract contract );
     Boolean check_and_replace(Contract contract);
}
