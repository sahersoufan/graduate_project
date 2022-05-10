package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.FriendsServiceImpl;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    private final FriendsServiceImpl friendsServiceImpl;
    private final UserService userService;

    @GetMapping(value = "/")
    public List<FriendsList> getFriends(HttpServletRequest request){
//        System.out.println("friends controller ");
        User user=userService.getUser(request);
        return friendsServiceImpl.getFrinends(user.getId());

    }

    @PostMapping(value = "/add")
    public String addFriends(@RequestBody String username,@RequestBody Long id){
        friendsServiceImpl.AddFriend(username, id);
        return "frinds";
    }

    @GetMapping(value = "/delete")
    public String deleteFriend(@RequestBody String username,@RequestBody Long id){
        friendsServiceImpl.deleteFriend(username, id);
        return "frinds";
    }

    @GetMapping(value = "/search/{username}")
    public List<User> searchOnFriends(@PathVariable("username") String username){
        return friendsServiceImpl.searchOnFriend(username);

    }
}
