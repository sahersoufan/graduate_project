package com.grad.exchangesys.chat.controller;

import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.UserService;
import com.grad.exchangesys.chat.model.ChatMessage;
import com.grad.exchangesys.chat.model.ChatNotification;
import com.grad.exchangesys.chat.model.ChatRoom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.grad.exchangesys.chat.service.ChatMessageService;
import com.grad.exchangesys.chat.service.ChatRoomService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api") @Slf4j
public class chatController {

	@Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private ChatMessageService chatMessageService;
    @Autowired private ChatRoomService chatRoomService;
    @Autowired  private  UserService userService;

    @MessageMapping("/chat")
    public void processMessage(ChatMessage chatMessage) {

        log.info("ChatMessage saved im  database: {}",chatMessage);

        User user=userService.getUser(chatMessage.getUser().getId());
        User user1=userService.getUser(chatMessage.getUser1().getId());
        var chatId = chatRoomService.getChatId(user, user1);
        chatMessage.setChatId(chatId);
        chatMessage.setUser(user);
        chatMessage.setUser1(user1);

        ChatMessage saved = chatMessageService.save(chatMessage);
        log.info("ChatMessage saved im  database: {}",saved);

        messagingTemplate.convertAndSendToUser(chatMessage.getUser().getId().toString(),
                "/queue/messages",
                saved);


    }

    @GetMapping("/messages/{senderId}/{recipientId}/count")
    public ResponseEntity<Long> countNewMessages(
            @PathVariable Long senderId,
            @PathVariable Long recipientId) {
        User user=userService.getUser(senderId);
        User user1=userService.getUser(recipientId);

        return ResponseEntity
                .ok(chatMessageService.countNewMessages(user, user1));
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public List<ChatMessage> findChatMessages ( @PathVariable long senderId,
                                                @PathVariable long recipientId) {
        User user=userService.getUser(senderId);
        User user1=userService.getUser(recipientId);
        return chatMessageService.findChatMessages(user, user1);
    }




    @GetMapping("/room/{senderId}/{recipientId}")
    public Boolean existroom(@PathVariable long senderId,
                             @PathVariable long recipientId){

        User user=userService.getUser(senderId);
        User user1=userService.getUser(recipientId);
        ChatRoom chatRoom=chatRoomService.getroom(user,user1);
        if(chatRoom==null){

            ChatRoom chatRoom1=new ChatRoom();
            ChatRoom chatRoom2=new ChatRoom();
            long count=chatRoomService.count();
            chatRoom1.setChatId(Long.toString(count));
            chatRoom1.setUser(user);
            chatRoom1.setUser1(user1);
            chatRoomService.saveroom(chatRoom1);


            chatRoom2.setChatId(Long.toString(count));
            chatRoom2.setUser(user1);
            chatRoom2.setUser1(user);
            chatRoomService.saveroom(chatRoom2);

        }
        return true;

    }

    @GetMapping("/userschat/{senderId}")
    public List<User> getusershavechat(@PathVariable long senderId){

        List<User> users=chatMessageService.getuser(senderId);
        for (int i=0;i<users.size();i++){
            if(users.get(i).getId()==senderId){
               User user=users.get(i);
                users.remove(user);
            }
        }
      return users;

    }



}
