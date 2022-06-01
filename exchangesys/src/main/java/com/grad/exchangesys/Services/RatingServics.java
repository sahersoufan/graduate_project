package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.Rating;
import com.grad.exchangesys.Model.User;

public interface RatingServics {

    String get_rate(Long id);
    Rating rate_Service (Rating rateOrder , User user);
    void update_rate(Rating rateOrder);
    void delete_rate(Long id);


}
