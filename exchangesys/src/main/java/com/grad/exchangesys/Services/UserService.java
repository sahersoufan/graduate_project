package com.grad.exchangesys.Services;


import com.grad.exchangesys.Model.User;
import com.sun.jdi.request.StepRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


public interface UserService {
    User saveUser(User user);

    User getUser(String email);
    User getUser(HttpServletRequest request );


}
