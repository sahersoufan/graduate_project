package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Repository.OrderRequestRepo;
import com.grad.exchangesys.Repository.OrdersRepo;
import com.grad.exchangesys.Services.OrderRequestServices;
import com.grad.exchangesys.Services.OrdersServices;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServicesImpl implements OrdersServices {

    private final OrdersRepo ordersRepo;
    private final UserService userService;
    private final OrderRequestRepo orderRequestRepo;

    @Override
    public List<Orders> getAllOrders(Long id) {
            List<Orders>myOrders = new ArrayList<>();
        for (Orders o : ordersRepo.findAll()) {
            if(o.getUser().getId()==id){
                myOrders.add(o);
            }
        }
        return myOrders;
    }

    @Override
    public List<Orders> getAllServiesProvider(Long id) {
        List<Orders> orders= new ArrayList<>();
        for (Orders o : ordersRepo.findAll())
        {
            if(o.getIdFrom()==id)
                orders.add(o);
        }
        return orders;
    }

    @Override
    public List<OrderRequest> getAll_Orders_Request(Long id_user) {
        List<OrderRequest> myOrders = new ArrayList<>();
        for (OrderRequest o : orderRequestRepo.findAll()){
            if(!o.getIs_offer() && o.getIdTo() == id_user ){
                myOrders.add(o);
            }
        }
        return myOrders;
    }

//    @Override
//    public void add_Order(Orders orders) {
//        ordersRepo.save(orders);
//    }

    @Override
    public void delete_Order(Long id_orders) {
        ordersRepo.delete(ordersRepo.getById(id_orders));

    }

    @Override
    public Orders Edite_Order(Orders orders) {

        Orders edite =ordersRepo.getById(orders.getId());
        edite=orders ; ordersRepo.save(edite);
        return edite;
    }
}
