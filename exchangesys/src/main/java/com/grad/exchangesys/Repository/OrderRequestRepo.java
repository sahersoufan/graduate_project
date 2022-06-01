package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRequestRepo extends JpaRepository<OrderRequest,Long> {

}
