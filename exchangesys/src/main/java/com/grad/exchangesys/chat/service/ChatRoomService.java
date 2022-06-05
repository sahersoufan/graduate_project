package com.grad.exchangesys.chat.service;

import java.util.List;
import java.util.Optional;

import com.grad.exchangesys.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.exchangesys.chat.model.ChatRoom;
import com.grad.exchangesys.chat.repository.ChatRoomRepo;

@Service
public class ChatRoomService {
	
	@Autowired 
	private ChatRoomRepo chatRoomRepository;

	public void saveroom(ChatRoom chatRoom){
        chatRoomRepository.save(chatRoom);

    }
    public long count() {
        return chatRoomRepository.count();
    }
    public ChatRoom getroom(User user, User user1){
	    if(chatRoomRepository.findByUserAndUser1(user, user1).isEmpty())
      return  null ;
	    return chatRoomRepository.findByUserAndUser1(user, user1).get();
    }
	public String getChatId(User sender, User recipient) {

	    if(chatRoomRepository.findByUserAndUser1(sender, recipient).isEmpty())
	        return null;
          return chatRoomRepository.findByUserAndUser1(sender, recipient).get().getChatId();
    }


}
