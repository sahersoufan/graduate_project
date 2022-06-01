package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Offers;
import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Repository.OffersRepo;
import com.grad.exchangesys.Repository.OrderRequestRepo;
import com.grad.exchangesys.Repository.OrdersRepo;
import com.grad.exchangesys.Services.OffersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class OffersServicesImpl implements OffersServices {

    private final OffersRepo offersRepo;
    private final OrderRequestRepo requestRepo;
    private final OrdersRepo ordersRepo;

    @Override
    public List<Offers> getAllOffers(Long id_user) {
        List<Offers> allOffers_Request = new ArrayList<>();
        for(Offers o : offersRepo.findAll()){
            if(o.getIdTo()==id_user ){
                allOffers_Request.add(o);
            }
        }
        return allOffers_Request;
    }

    @Override
    public List<OrderRequest> getAll_Offers_Request(Long id_user) {

        List<OrderRequest> myOffers= new ArrayList<>();
        for (OrderRequest o : requestRepo.findAll()){
            if(o.getIs_offer() &&o.getIdTo() == id_user ){
                myOffers.add(o);
            }
        }
            return myOffers;
    }

    @Override
    public Boolean AcceptOrder(Long id_offer) {
        OrderRequest orderRequest= new OrderRequest();
        Offers accept = new Offers();
        orderRequest = requestRepo.getById(id_offer);

        if(orderRequest!= null) {
            accept = accept.convertObject(orderRequest);
            offersRepo.save(accept);
            requestRepo.delete(orderRequest);
            return true;
        }
        return false;
    }

    @Override
    public void deleteOrder(Long id_reqest) {
        requestRepo.delete(requestRepo.getById(id_reqest));

    }


//    @Override
//    public List<OrderAccept> getallOrders(Long id) {
//        List<OrderAccept> orders= new ArrayList<>();
//            for (OrderAccept o : orderAcceptRepo.findAll())
//            {
//                if(o.getIdTo()==id)
//                    orders.add(o);
//            }
//        return orders;
//    }

//    @Override
//    public List<OrderAccept> ViesAllServiesProvider(Long id) {
//
//        List<OrderAccept> orders= new ArrayList<>();
//        for (OrderAccept o : orderAcceptRepo.findAll())
//        {
//            if(o.getIdFrom()==id)
//                orders.add(o);
//        }
//        return orders;
//    }

//    @Override
//    public void AcceptOrder(Long id_user , Long id_RequestOrder) {
//        OrderRequest orderRequest= new OrderRequest();
//        OrderAccept accept= new OrderAccept();
//        orderRequest = requestRepo.getById(id_RequestOrder);
//
//        accept= accept.convertObject(orderRequest);
//        orderAcceptRepo.save(accept);
//        requestRepo.delete(orderRequest);
////        ordersRepo.delete(ordersRepo.getById(orderRequest.getIdOrder()));
//    }

//    @Override
//    public void CancelOrder(Long id_RequestOrder) {
//        OrderRequest orderRequest= requestRepo.getById(id_RequestOrder);
//        requestRepo.delete(orderRequest);
//    }

}
