package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.OrdersServices;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersServices ordersServices;
    private final UserService userService;

    @GetMapping("/")
    public List<Orders> getAllOrders(HttpServletRequest request){
        User user = userService.getUser(request);
//        System.out.println("get orders  :  "+ ordersServices.getAll_Orders_Request(user.getId()));
          return  ordersServices.getAllOrders(user.getId());
    }
//    @GetMapping("/Requests")
//    public List<OrderRequest> getAll_Offers_Requests(HttpServletRequest request){
//        User user = userService.getUser(request);
//        return  ordersServices.getAll_Orders_Request(user.getId());
//    }

    @DeleteMapping("/delete/{Id}")
    public void Delete_Order(@PathVariable Long Id, HttpServletRequest request){
        ordersServices.delete_Order(Id);
    }


}
