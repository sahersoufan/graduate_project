package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {

//        @Query("update ")
//        Orders update_Order(Long id);
}
