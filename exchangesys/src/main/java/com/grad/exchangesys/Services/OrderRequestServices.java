package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OrderRequestServices {

    List<OrderRequest> viewAllServicesRequest(Long id);
    String Offer_service_TO_user(String service_name, Long id_other_user, Long id_my_user );
    void add_Order(OrderRequest orders) ;
    void AcceptOrder( Long id_RequestOrder);
//    void AcceptOffer( Long id_RequestOrder);
    void CancelOrder(Long id_reqest);


}
