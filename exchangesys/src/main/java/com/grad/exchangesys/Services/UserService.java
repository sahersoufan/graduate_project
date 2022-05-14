package com.grad.exchangesys.Services;


import com.grad.exchangesys.Model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface UserService {
    User saveUser(User user);

    User getUser(String email);
    User getUser(Long id);
    List<User>All(Long id);
    List<User>getusernotfriend(String email);
    User getUser(HttpServletRequest request );
    User UpdateUser(User user);

}
