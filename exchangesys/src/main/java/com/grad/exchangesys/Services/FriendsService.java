package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FriendsService {

    List<FriendsList> getFrinends(Long id);
    User AddFriend(String username ,Long id);
    List<User> searchOnFriend(String name);
    void deleteFriend(String username, Long id);
}
