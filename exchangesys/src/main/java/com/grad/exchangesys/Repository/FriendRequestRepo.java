package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.FriendRequest;
import com.grad.exchangesys.Model.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FriendRequestRepo  extends JpaRepository<FriendRequest, Long> {
    @Query("SELECT f  FROM FriendRequest f " +
            "WHERE f.user_id = :id ")
        List<FriendRequest> getAllByUser_id(Long id);
    @Query("SELECT f  FROM FriendRequest f " +
            "WHERE f.user.id = :id ")
    List<FriendRequest> allrequesttouser(Long id);

    @Query("SELECT f  FROM FriendRequest f " +
            "WHERE f.user.id = :Fid and f.user_id=:Uid ")
    FriendRequest getfriendrequest(Long Uid,Long Fid);
}


