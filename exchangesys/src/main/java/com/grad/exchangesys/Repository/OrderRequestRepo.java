package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRequestRepo extends JpaRepository<OrderRequest,Long> {
    @Query("SELECT o  FROM OrderRequest o " +
            "WHERE  o.provider.id=:id  and o.isaccept=false ORDER BY o.id desc")
    List<OrderRequest> findByProviderOrderByIdDesc(Long id);

    @Query("SELECT o  FROM OrderRequest o " +
            "WHERE  o.provider.id=:id  and o.isaccept=true ORDER BY o.id desc")
    List<OrderRequest> findByProvider(Long id);

    @Query("SELECT o  FROM OrderRequest o " +
            "WHERE  o.customer.id=:id   ORDER BY o.id desc")
    List<OrderRequest> findByCustomerOrderByIdDesc(Long id);

    @Query("SELECT o  FROM OrderRequest o " +
            "WHERE  ((o.customer.id=:id AND  o.provider.id=:pid )or(o.customer.id=:pid AND  o.provider.id=:id )) And o.isaccept=true")
    List<OrderRequest> countByProviderAndCustomerAndIsaccept(Long pid,Long id);

}
