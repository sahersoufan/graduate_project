package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FriendsService {

   List<FriendsList> getFrinends(Long id);
     void AddFriend(FriendsList friendsList);
     List<User> getusersFriend(Long id);
     FriendsList getFriend(Long user_id,Long f_id);
     Boolean  deleteFriend(FriendsList friendsList);
     long getcount(long id);

}
