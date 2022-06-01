package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.Orders;
import com.grad.exchangesys.Model.Rating;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Repository.OrdersRepo;
import com.grad.exchangesys.Repository.RatingRepo;
import com.grad.exchangesys.Services.RatingServics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingServics {

        private final RatingRepo ratingRepo;
        private final OrdersRepo ordersRepo;


    @Override
    public String get_rate(Long id_order) {
        Rating rating= new Rating();
//        rating = ratingRepo.getById(id);
            for (Rating r : ratingRepo.findAll() )
            {
                if(r.getOrder().getId()==id_order)
                    rating=r;
            }
        return rating.getRate();
    }

    @Override
    public Rating rate_Service(Rating rateOrder , User user) {
        Rating rating=  new Rating();
        rating.setRate(rateOrder.getRate());
        rating.setServiceNmae(rating.getServiceNmae());
        rating.setUser(user);
        rating.setOrder(rateOrder.getOrder());
             return ratingRepo.save(rating);
    }

    @Override
    public void update_rate(Rating rateOrder) {
        Rating update = ratingRepo.getById(rateOrder.getId());
        update= rateOrder;
        ratingRepo.save(update);

    }

    @Override
    public void delete_rate(Long id) {
        Rating delete = ratingRepo.getById(id);
        ratingRepo.delete(delete);

    }
}
