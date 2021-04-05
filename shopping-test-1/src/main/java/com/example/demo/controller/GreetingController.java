package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.bean.Chat;
import com.example.demo.bean.Message;

@Controller
public class GreetingController {
	@Autowired
	SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception{
		return message;
	}
	
	@MessageMapping("/chat")
	public void chat(Principal principal,Chat chat) {
		chat.setFrom(principal.getName());
		this.messagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
		
	}
}
