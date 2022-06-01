package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Offers;
import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Repository.OffersRepo;
import com.grad.exchangesys.Repository.OrderRequestRepo;
import com.grad.exchangesys.Repository.OrdersRepo;
import com.grad.exchangesys.Repository.UserRepo;
import com.grad.exchangesys.Services.OrderRequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class OrderRequestServicesImpl implements OrderRequestServices {

    private final OrderRequestRepo requestRepo;
    private final OffersRepo offersRepo;
    private final OrdersRepo ordersRepo;
    private final UserRepo userRepo;

    @Override
    public List<OrderRequest> viewAllServicesRequest(Long id_user) {
        List<OrderRequest> allOrdesRequest = new ArrayList<>();
        for(OrderRequest o : requestRepo.findAll()){
            if(o.getIdTo()==id_user){
                allOrdesRequest.add(o);
            }
        }
        return allOrdesRequest;
    }

    @Override
    public String Offer_service_TO_user (String service_name, Long id_other_user, Long id_my_user ) {

        OrderRequest request= new OrderRequest();

        User  user_offer= userRepo.getById(id_other_user);
        User  me= userRepo.getById(id_my_user);

        request.setServiceNmae(service_name);
        request.setToN(user_offer.getUsername());
        request.setFormN(me.getUsername());

        request.setIdFrom(me.getId());
        request.setIdTo(user_offer.getId());

        request.setUser(user_offer);
        request.setIs_offer(true);

        requestRepo.save(request);

        return "Offer sent";
    }

    @Override
    public OrderRequest add_Order(OrderRequest order) {

        order.setIs_offer(false);
        return requestRepo.save(order);
    }

    @Override
    public Boolean AcceptOrder(Long id_RequestOrder) {
        OrderRequest orderRequest= new OrderRequest();
        Orders accept = new Orders();
        orderRequest = requestRepo.getById(id_RequestOrder);

        if(orderRequest !=null) {
            accept = accept.convertObject(orderRequest);
            ordersRepo.save(accept);
            requestRepo.delete(orderRequest);
            return true;
        }
        return false;
    }

//    @Override
//    public void AcceptOffer(Long id_RequestOrder) {
//
//    }

    @Override
    public void CancelOrder(Long id_reqest) {
        requestRepo.delete(requestRepo.getById(id_reqest));
    }


}
