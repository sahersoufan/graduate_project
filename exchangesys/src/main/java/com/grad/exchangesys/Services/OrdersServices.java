package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Repository.OrdersRepo;

import java.util.List;

public interface OrdersServices {

        List<Orders>getAllOrders(Long id);
        List<Orders> getAllServiesProvider(Long id);
        List<OrderRequest> getAll_Orders_Request(Long id);

         void delete_Order(Long orders) ;
         Orders Edite_Order(Orders orders) ;
}
