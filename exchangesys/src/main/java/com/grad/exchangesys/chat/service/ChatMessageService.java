package com.grad.exchangesys.chat.service;

import java.util.ArrayList;
import java.util.List;

import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.grad.exchangesys.chat.model.ChatMessage;
import com.grad.exchangesys.chat.model.MessageStatus;
import com.grad.exchangesys.chat.repository.ChatMessageRepo;
import com.grad.exchangesys.exception.ResourceNotFoundException;



@Service
public class ChatMessageService {

	@Autowired 
	private ChatMessageRepo repository;
	
    @Autowired 
    private ChatRoomService chatRoomService;


    
    
    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(User sender, User recipient) {
        return repository.countByUserAndUser1AndStatus(
                sender, recipient, MessageStatus.RECEIVED);
    }

    public List<ChatMessage> findChatMessages(User sender, User recipient) {
        String chatId = chatRoomService.getChatId(sender, recipient);
        List<ChatMessage> messages=repository.findByChatId(chatId);
        if(messages.size() > 0) {
            for (int i=0;i<messages.size();i++){
                messages.get(i).setStatus(MessageStatus.DELIVERED);
                repository.save(messages.get(i));
            }

        }
        return messages;
    }



    public List<User> getuser(Long id){
        return repository.getusers(id);

    }
    
    
}
