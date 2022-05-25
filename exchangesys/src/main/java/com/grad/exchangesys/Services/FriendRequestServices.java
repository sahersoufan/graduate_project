package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.ActivityFriends;
import com.grad.exchangesys.Model.FriendRequest;
import com.grad.exchangesys.Model.User;

import java.util.List;


public interface FriendRequestServices {
    boolean AddRequest(FriendRequest friendRequest);
    List<FriendRequest> AllFriendRequest(Long id);
    List<FriendRequest> All();
    FriendRequest getrequest(Long id,Long friend_id);
    Boolean deleterequest(FriendRequest friendRequest);
    List<FriendRequest> allrequesttouser(long id);
    List<ActivityFriends> getActivate(User user);
    ActivityFriends saveactivity(ActivityFriends activityFriends);


}
