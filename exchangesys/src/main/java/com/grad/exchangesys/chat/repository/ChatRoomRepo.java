package com.grad.exchangesys.chat.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grad.exchangesys.chat.model.ChatRoom;

public interface ChatRoomRepo extends MongoRepository<ChatRoom, String> {

	Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
