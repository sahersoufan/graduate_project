package com.grad.exchangesys.Controller;

import com.grad.exchangesys.Model.*;
import com.grad.exchangesys.Services.FriendRequestServices;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/friendrequest")
public class FriendRequestController {
    private final UserService userService;
    private final FriendRequestServices friendRequestServices;


    @PostMapping(value = "/add/{id}")
    public Boolean addFriends(@PathVariable("id") Long id, HttpServletRequest request){
        FriendRequest friendRequest=new FriendRequest();
        User user=userService.getUser(request);
        friendRequest.setUser_id(user.getId());
        User user1=userService.getUser(id);
        friendRequest.setUser(user1);
        friendRequestServices.AddRequest(friendRequest);
        ActivityFriends activityFriends=new ActivityFriends();
        activityFriends.setName("add");
        activityFriends.setFriendname(user1.getFirstname());
        activityFriends.setType("send");
        activityFriends.setUser(user);
        friendRequestServices.saveactivity(activityFriends);
        if(friendRequestServices.AddRequest(friendRequest))
            return true;
        return false;

    }

    @PostMapping(value = "/all")
    public  ResponseEntity< List <Map<String, String>>>allrequest(HttpServletRequest request){
        List <Map<String, String>>mapList = new ArrayList<>();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/friendrequest/all").toUriString());
        User user=userService.getUser(request);

        List<FriendRequest> friendRequests=friendRequestServices.allrequesttouser(user.getId());
        for (FriendRequest friendRequest : friendRequests) {
            Map<String, String> map = new HashMap<>();
            User user1 = userService.getUser(friendRequest.getUser_id());
            map.put("id", user1.getId().toString());
            map.put("imagepath", user1.getImagepath());
            map.put("firstname", user1.getFirstname());
            map.put("lastname", user1.getLastname());
            map.put("description", user1.getDescription());
            mapList.add(map);

        }
        return ResponseEntity.created(uri).body(mapList);

    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id,HttpServletRequest request){

        User user=userService.getUser(request);

        FriendRequest friendRequest=friendRequestServices.getrequest(id,user.getId());

        friendRequestServices.deleterequest(friendRequest);

        return new ResponseEntity<String>("Service Deleted Successfully!.", HttpStatus.OK);

    }

    @GetMapping("/activity")
    public List<ActivityFriends> getactivity(HttpServletRequest request){
        User user=userService.getUser(request);
        return friendRequestServices.getActivate(user);
    }
}
