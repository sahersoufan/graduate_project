package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.Contract;
import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.ServiceModel;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.ContractService;
import com.grad.exchangesys.Services.OrderRequestServices;
import com.grad.exchangesys.Services.ServiceService;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ordersrequests")
public class OrderRequestController {

  private final OrderRequestServices orderServices;
  private final UserService userService;
  private final ServiceService serviceService;
  private final ContractService contractService;



  @GetMapping("/all")
  public List<OrderRequest> getAll_Services_Requests(HttpServletRequest request){
    User user= userService.getUser(request);
  List<OrderRequest> order=  orderServices.viewAllServicesRequest(user);
  return order;
  }

  @GetMapping("/customerall")
  public List<OrderRequest> getAllCustomerServicesRequests(HttpServletRequest request){
    User user= userService.getUser(request);
    List<OrderRequest> order=  orderServices.viewAllCusmerrequest(user);
    return order;
  }

  @GetMapping("/allconfirm")
  public List<OrderRequest> getAllServicesRequestsConfirm(HttpServletRequest request){
    User user= userService.getUser(request);
    List<OrderRequest> order=  orderServices.viewAllconfirmServicesRequest(user);
    return order;
  }



  @PostMapping("/add/{id}")
  public Boolean Add_Order(@RequestBody OrderRequest orders,@PathVariable Long id, HttpServletRequest request){
    User user = userService.getUser(request);
    User user1=userService.getUser(orders.getCustomer().getId());
    ServiceModel serviceModel=serviceService.getServiceById(id);
    orders.setProvider(user1);
    orders.setCustomer(user);
    orders.setIsaccept(false);
    orders.setServiceModel(serviceModel);
    orderServices.add_Order(orders);


    return true;
  }

  @GetMapping("/confirm/{id}")
  public Boolean accept_order(@PathVariable Long id,HttpServletRequest request){

    OrderRequest orderRequest=orderServices.getOrder(id);
    orderRequest.setIsaccept(true);
    orderServices.add_Order(orderRequest);

  return true;
  }

  @GetMapping("/check/{id}")
  public Boolean check(@PathVariable Long id,HttpServletRequest request){
    User provider= userService.getUser(request);
    User custmer=userService.getUser(id);


   List<OrderRequest> orderRequests= orderServices.countorder(provider,custmer);
    if(orderRequests!=null){
      if(orderRequests.size()>0)
        for (int i=0;i<orderRequests.size();i++){
          Contract contract=contractService.getcontact(orderRequests.get(i));
          if(contract!=null) {
            if (orderRequests.get(i).getProvider().getId() == provider.getId()) {


                if (contract.getConditionuser1() == null) {
                  return true;
                }

            } else if (orderRequests.get(i).getProvider().getId() == custmer.getId()) {
              if (contract.getConditionuser2() == null) {
                return true;
              }

            }
          }else {
            return true;
          }
        }

    }
    return false;
  }
  @GetMapping("/allconfirm/{id1}/{id2}")
  public List<OrderRequest> getAllReqConfirm(@PathVariable Long id1,@PathVariable Long id2){
    User user1= userService.getUser(id1);
    User user2= userService.getUser(id2);

    List<OrderRequest> orderRequests=new ArrayList<>();
    orderRequests=orderServices.countorder(user1,user2);
    for (int i=0;i<orderRequests.size();i++){
      Contract contract=contractService.getcontact(orderRequests.get(i));
      if(contract!=null) {
        if (orderRequests.get(i).getProvider().getId() == user1.getId()) {


          if (contract.getConditionuser1() != null) {
           orderRequests.remove(orderRequests.get(i));
          }

        } else if (orderRequests.get(i).getCustomer().getId() == user1.getId()) {
          if (contract.getConditionuser2() != null) {
            orderRequests.remove(orderRequests.get(i));
          }

        }

      }
    }
    return orderRequests ;
  }

  @DeleteMapping("/delete/{id}")
  public void delete_Request(@PathVariable Long id){
    orderServices.CancelOrder(id);
  }







}
