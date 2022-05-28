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
@RequestMapping("/api/ordersrequests")
public class OrderRequestController {

  private final OrderRequestServices orderServices;
  private final UserService userService;
  private final OffersServices offersServices;



  @GetMapping("/")
  public List<OrderRequest> getAll_Services_Requests(HttpServletRequest request){
    User user= userService.getUser(request);
//    System.out.println("get request orders  :  "+ orderServices.viewAllServicesRequest(user.getId()));
   return orderServices.viewAllServicesRequest(user.getId());
  }



  @PostMapping("/addorder")
  public Boolean Add_Order(@RequestBody OrderRequest orders, HttpServletRequest request){
    User user = userService.getUser(request);
    orders.setUser(user);

    if(orderServices.add_Order(orders)!=null)
        return true;
    return false;
  }

  @GetMapping("/acceptorder/{id}")
  public String accept_order(@PathVariable Long id,HttpServletRequest request){
    if(orderServices.AcceptOrder(id))
      return "Request accepted";
  return "the order was deleted";
  }

  @DeleteMapping("/delete/{id}")
  public void delete_Request(@PathVariable Long id){
    orderServices.CancelOrder(id);
  }

  @PostMapping("/offerservice")
  public String offer_service(@RequestBody OrderRequest orders,@RequestBody Long id_To_user ,HttpServletRequest request){
    User user = userService.getUser(request);
//    orders.setUser(user);
//    orders.setIdFrom(user.getId());
//    orders.setFormN(user.getUsername());
//    orders.setIdTo(id_To_user);
       return orderServices.Offer_service_TO_user(orders.getServiceNmae(),orders.getIdTo(),user.getId());
  }

  @GetMapping("/acceptoffer/{id}")
  public String accept_offer(@PathVariable Long id,HttpServletRequest request){

   if(offersServices.AcceptOrder(id))
       return "Request accepted";
    return "the order was deleted";
  }





}
