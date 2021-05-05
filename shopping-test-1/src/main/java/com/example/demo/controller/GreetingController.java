package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.chat.Chat;
import com.example.demo.bean.chat.Message;
import com.example.demo.service.ChatService;
/**
 * 聊天接口
 * @author dy-xx
 *
 */
@Controller
public class GreetingController {
	@Autowired
	SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	ChatService cService;
	
	/**
	 * 群发
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception{
		return message;
	}
	
	/**
	 * 点对点发送
	 * @param principal 获取发送人
	 * @param chat   发送信息类
	 */
	@MessageMapping("/chat")
	public void chat(Principal principal,Chat chat) {
		if(principal==null) {
			return;
		}
		chat.setFromUser(principal.getName());
		chat.setCrateDate(new Date());
		this.messagingTemplate.convertAndSendToUser(chat.getToUser(), "/queue/chat", chat);
		this.cService.insertChat(chat);
	}
	
	/**
	 * 获取聊天记录
	 * @param fromUser 发送用户名
	 * @param toUser  接受用户名
	 * @return 聊天列表
	 */
	@RequestMapping(value="/userChat/getUserChat", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Chat> getUserChat(@RequestParam("fromUser") String fromUser,@RequestParam("toUser")String toUser){
		return this.cService.getUserChat(fromUser, toUser);
	}
}
