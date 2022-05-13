package com.grad.exchangesys.Services;

import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Repository.FriendsListRepo;
import com.grad.exchangesys.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendsServiceImpl implements FriendsService {

      private final  FriendsListRepo friendsListRepo;
      private final UserRepo userRepo;

   @Override
    public List<FriendsList> getFrinends(Long id) {
       return friendsListRepo.findAllByUser_id(id);
    }

    @Override
    public void AddFriend(FriendsList friendsList) {
        assert false;
        friendsListRepo.save(friendsList);
    }

    @Override
    public List<User> getusersFriend(Long id) {
        return friendsListRepo.findusersfriend(id);
    }

    @Override
    public FriendsList getFriend(Long user_id, Long f_id) {
        return friendsListRepo.getfriend(user_id,f_id);
    }

    @Override
    public Boolean deleteFriend(FriendsList friendsList) {
         friendsListRepo.delete(friendsList);
         return true;
    }


}
