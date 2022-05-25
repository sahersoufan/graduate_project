package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.OffersServices;
import com.grad.exchangesys.Services.OrderRequestServices;
import com.grad.exchangesys.Services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders-requests")
public class OrderRequestController {

  private final OrderRequestServices orderServices;
  private final UserService userService;
  private final OffersServices offersServices;



  @GetMapping("/")
  public List<OrderRequest> getAll_Services_Requests(HttpServletRequest request){
    User user= userService.getUser(request);
   return orderServices.viewAllServicesRequest(user.getId());
  }



  @PostMapping(value = "/add-order")
  public void Add_Order(@RequestBody OrderRequest orders, HttpServletRequest request){
    User user = userService.getUser(request);
    orders.setUser(user);
    orderServices.add_Order(orders);
  }

  @GetMapping(value ="/accept-order{id}")
  public void accept_order(@PathVariable Long id,HttpServletRequest request){
      orderServices.AcceptOrder(id);
  }

  @DeleteMapping("/delete{id}")
  public void delete_Request(@PathVariable Long id){
    orderServices.CancelOrder(id);
  }

  @PostMapping(value = "/offer-service")
  public void offer_service(@RequestBody OrderRequest orders,@RequestBody Long id_To_user ,HttpServletRequest request){
    User user = userService.getUser(request);
//    orders.setUser(user);
//    orders.setIdFrom(user.getId());
//    orders.setFormN(user.getUsername());
//    orders.setIdTo(id_To_user);
    orderServices.Offer_service_TO_user(orders.getServiceNmae(),orders.getIdTo(),user.getId());
  }

  @GetMapping(value ="/accept-offer{id}")
  public void accept_offer(@PathVariable Long id,HttpServletRequest request){
    offersServices.AcceptOrder(id);
  }





}
