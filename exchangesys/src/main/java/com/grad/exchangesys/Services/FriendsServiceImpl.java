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

    private final  FriendsListRepo friendsListRepo=null;
    private final UserRepo userRepo=null;

    @Override
    public List<FriendsList> getFrinends(Long id) {

        List <FriendsList> myfriends =new ArrayList<>();
        List<FriendsList> friends=friendsListRepo.findAll();
        System.out.println("friends   :");
        for (int i=0 ;i< friends.size(); i++){
            if (friends.get(i).getId_user()==id){
//                    System.out.println("  name             :  "+friends.get(i).getName());
//                    System.out.println("  friend  id       :  "+friends.get(i).getId_friend());
                myfriends.add(friends.get(i));
            }
        }
        return myfriends;

    }

    @Override
    public List<User> searchOnFriend(String username) {
        List<User> result = new ArrayList<>();

        for(int i=0 ; i< userRepo.findAll().size(); i++){
            if(userRepo.findByUsername(username).equals(username)) {
//            System.out.println("user found    \n\t  name   :   "+username);
//            System.out.println("              \n\t  gender :   "+userRepo.findByUsername(username).getGender());
//            System.out.println("              \n\t  age    :   "+userRepo.findByUsername(username).getAge());
                result.add(userRepo.findByUsername(username));
            }
        }
        return result;
    }

    @Override
    public User AddFriend(String username, Long id) {
        FriendsList friendsList = friendsListRepo.getById (id);
        User newfriend = userRepo.findByUsername(username);
        friendsList.setId_friend(newfriend.getId());
        friendsList.setName(username);
        friendsListRepo.save(friendsList);

        return userRepo.findByUsername(username);
    }

    @Override
    public void deleteFriend(String username, Long id) {
        FriendsList friendsList = friendsListRepo.getById (id);

//        System.out.println(" column deleted  :\n friend name  :    "+ friendsList.getName() +"" +
//                "\n  friend Id :    "+friendsList.getId_friend());
        friendsListRepo.delete(friendsList);
    }

}
