package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.Rating;
import com.grad.exchangesys.Services.RatingServics;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingServics ratingServics;
    private final UserService userService;

    @GetMapping("/{id}")
    public String get_rating_of_order(@PathVariable Long id){
        return ratingServics.get_rate(id);
    }

    @PostMapping("add")
    public Rating Rate_service(@RequestBody Rating rate, HttpServletRequest request){
           return ratingServics.rate_Service(rate,userService.getUser(request));
    }

    @GetMapping("/delete/{id}")
    public void delete_rate(@PathVariable Long id){
        ratingServics.delete_rate(id);
    }

    @PostMapping("/update")
    public void update_rate(@RequestBody Rating rate,HttpServletRequest request){
        rate.setUser(userService.getUser(request));
        ratingServics.update_rate(rate);
    }
}
