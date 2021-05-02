package com.example.demo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.chat.Chat;
import com.example.demo.dao.chatMapper.ChatMapper;
import com.example.demo.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{
     @Autowired
     ChatMapper cMapper;
     
     public void insertChat(Chat c) {
    	 this.cMapper.insertChat(c);
     }

	@Override
	public ArrayList<Chat> getUserChat(String fromUser, String toUser) {
		// TODO Auto-generated method stub
		return this.cMapper.getUserChat(fromUser, toUser);
	}
}
