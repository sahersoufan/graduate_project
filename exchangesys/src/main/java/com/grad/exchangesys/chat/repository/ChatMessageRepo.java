package com.grad.exchangesys.chat.repository;

import java.util.List;

import com.grad.exchangesys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import com.grad.exchangesys.chat.model.ChatMessage;
import com.grad.exchangesys.chat.model.MessageStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChatMessageRepo extends JpaRepository<ChatMessage, String> {


    long countByUserAndUser1AndStatus(User user, User user1, MessageStatus status);
	@Query("SELECT distinct u  FROM User u,ChatMessage c where c.user1.id=u.id AND( c.user1.id=:id or c.user.id=:id) ORDER BY c.timestamp desc ")
    List<User> getusers(Long id);
    List<ChatMessage> findByChatId(String chatId);

}
