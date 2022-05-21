package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.FriendsList;
import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendsListRepo extends JpaRepository<FriendsList , Long> {


    List<FriendsList> findAllByUser_id(Long id);
    @Query("SELECT u  FROM User u,FriendsList f WHERE f.user_id=:id" )
    List<User>findusersfriend(Long id);

    @Query("SELECT f  FROM FriendsList f WHERE f.user_id=:user and f.user.id=:friend" )
    FriendsList getfriend(Long user,Long friend);


    long countByUser_id(long user_id);

}
