package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.Offers;
import com.grad.exchangesys.Model.OrderRequest;
import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.OffersServices;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/offers")
public class OffersController {

    private final OffersServices offersServices;
    private final UserService userService;

    @GetMapping("/")
    public List<Offers> getAllOffers(HttpServletRequest request){
        User user = userService.getUser(request);
        return  offersServices.getAllOffers(user.getId());
    }

    @GetMapping("/requests")
    public List<OrderRequest> getAll_Offers_Requests(HttpServletRequest request){
        User user = userService.getUser(request);
        return  offersServices.getAll_Offers_Request(user.getId());
    }

    @DeleteMapping(value = "/delete{Id}")
    public void Delete_Offer(@PathVariable Long Id, HttpServletRequest request){
        offersServices.deleteOrder(Id);
    }



}
