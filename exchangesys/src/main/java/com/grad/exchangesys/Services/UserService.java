package com.grad.exchangesys.Services;


import com.grad.exchangesys.Model.User;

import javax.servlet.http.HttpServletRequest;


public interface UserService {
    User saveUser(User user);

    User getUser(String email);
    User getUser(HttpServletRequest request );

}
