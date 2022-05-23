package com.grad.exchangesys.Repository;

import com.grad.exchangesys.Model.ActivityFriends;

import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityFriendsRepo extends JpaRepository<ActivityFriends,Long> {
    List<ActivityFriends> findTop3ByUserOrderByIdDesc(User user);

}
