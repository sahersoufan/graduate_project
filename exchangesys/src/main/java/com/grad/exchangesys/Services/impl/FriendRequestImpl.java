package com.grad.exchangesys.Services.impl;

import com.grad.exchangesys.Model.FriendRequest;
import com.grad.exchangesys.Repository.FriendRequestRepo;
import com.grad.exchangesys.Services.FriendRequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestImpl implements FriendRequestServices {
    private final FriendRequestRepo friendRequestRepo;
    @Override
    public boolean AddRequest(FriendRequest friendRequest) {

        FriendRequest friendRequest1=friendRequestRepo.save(friendRequest);
        return friendRequest1.getId() != null;

    }

    @Override
    public List<FriendRequest> AllFriendRequest(Long id) {
        return  friendRequestRepo.getAllByUser_id(id);
    }

    @Override
    public List<FriendRequest> All() {
        return friendRequestRepo.findAll();
    }

    @Override
    public FriendRequest getrequest(Long id,Long f_id) {
        return friendRequestRepo.getfriendrequest(id,f_id);
    }

    @Override
    public Boolean deleterequest(FriendRequest friendRequest) {
        friendRequestRepo.delete(friendRequest);
       return true;
    }

    @Override
    public List<FriendRequest> allrequesttouser(long id) {
        return friendRequestRepo.allrequesttouser(id);
    }
}
