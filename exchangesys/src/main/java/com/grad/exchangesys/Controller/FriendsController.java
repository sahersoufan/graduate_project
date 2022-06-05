package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.*;
import com.grad.exchangesys.Services.FriendRequestServices;
import com.grad.exchangesys.Services.FriendsService;
import com.grad.exchangesys.Services.FriendsServiceImpl;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    private final FriendsService friendsServiceImpl;
    private final UserService userService;
    private final FriendRequestServices friendRequestServices;

    @PostMapping(value = "/getfriend/{id}")
    public ResponseEntity<User> getfriend(@PathVariable("id") Long id,HttpServletRequest request){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/getuser").toUriString());

        User user=userService.getUser(id);

        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping(value = "/add/{id}")
    public Boolean addFriends(@PathVariable("id") Long id,HttpServletRequest request){

        User user=userService.getUser(request);

        FriendRequest friendRequest=friendRequestServices.getrequest(id,user.getId());

        FriendsList friendsList=new FriendsList();
        friendsList.setUser_id(friendRequest.getUser_id());
        friendsList.setUser(friendRequest.getUser());
        friendsList.setIszone((long) 0);
        friendsServiceImpl.AddFriend(friendsList);

        FriendsList friendsList1=new FriendsList();
        friendsList1.setUser_id(friendRequest.getUser().getId());
        friendsList1.setUser(userService.getUser(friendRequest.getUser_id()));
        friendsList1.setIszone((long) 0);
        friendsServiceImpl.AddFriend(friendsList1);


        ActivityFriends activityFriends=new ActivityFriends();
        activityFriends.setName("add");

        activityFriends.setFriendname(userService.getUser(friendRequest.getUser_id()).getFirstname());
        activityFriends.setType("accept");
        activityFriends.setUser(user);
        friendRequestServices.saveactivity(activityFriends);


        friendRequestServices.deleterequest(friendRequest);
        return true;




    }

    @PostMapping(value = "/allfriend")
    public List <Map<String, String>> getFriends(HttpServletRequest request){
        List <Map<String, String>>mapList = new ArrayList<>();

        User user=userService.getUser(request);
        List<FriendsList>users = friendsServiceImpl.getFrinends(user.getId());
        for (FriendsList f : users) {
            Map<String, String> map = new HashMap<>();
            User user1=userService.getUser(f.getUser_id());
            map.put("id", user1.getId().toString());
            map.put("imagepath", user1.getImagepath());
            map.put("firstname", user1.getFirstname());
            map.put("lastname", user1.getLastname());
            map.put("description", user1.getDescription());
            mapList.add(map);

        }
        return mapList;

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id, HttpServletRequest request){

        User user=userService.getUser(request);

        FriendsList friendsList=friendsServiceImpl.getFriend(user.getId(),id);

        friendsServiceImpl.deleteFriend(friendsList);
        FriendsList friendsList1=friendsServiceImpl.getFriend(id,user.getId());

        friendsServiceImpl.deleteFriend(friendsList1);


        return new ResponseEntity<String>("friend Deleted Successfully!.", HttpStatus.OK);

    }

    @GetMapping("/count")
    public long count(HttpServletRequest request){

        User user=userService.getUser(request);
       return friendsServiceImpl.getcount(user.getId());
    }

}
