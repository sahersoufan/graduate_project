package com.grad.exchangesys.Services;


import com.grad.exchangesys.Model.Offers;
import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;

import java.util.List;

public interface OffersServices {


    List<Offers>getAllOffers(Long id_user);
    List<OrderRequest> getAll_Offers_Request(Long id);

    Boolean AcceptOrder( Long id_RequestOrder);
    void deleteOrder(Long id_reqest);
//    List<OrderAccept> getallOrders(Long id);
//    List<OrderAccept> ViesAllServiesProvider(Long id);
//    void AcceptOrder(Long id_user , Long id_RequestOrder);
//    void CancelOrder(Long id_OrderRequest) ;

}
