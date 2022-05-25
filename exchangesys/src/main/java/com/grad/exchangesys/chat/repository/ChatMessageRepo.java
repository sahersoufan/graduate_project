package com.grad.exchangesys.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grad.exchangesys.chat.model.ChatMessage;
import com.grad.exchangesys.chat.model.MessageStatus;

public interface ChatMessageRepo extends MongoRepository<ChatMessage, String>{

	long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}
