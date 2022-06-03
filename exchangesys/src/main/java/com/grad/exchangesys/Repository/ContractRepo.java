package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract,Long> {
}
