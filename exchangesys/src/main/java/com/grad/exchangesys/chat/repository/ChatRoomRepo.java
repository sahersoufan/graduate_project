package com.grad.exchangesys.chat.repository;

import java.util.List;
import java.util.Optional;


import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.chat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, String> {

	Optional<ChatRoom> findByUserAndUser1(User user, User user1);


}
